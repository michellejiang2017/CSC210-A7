public class DecisionTree extends BinaryTree<String> { 

    /**
     * Constructor for leaf node
     * @param data string to pass with data
     */
    public DecisionTree(String data) { 
        super(data);
    }

    /**
     * Constructor for branch node
     * @param data
     * @param left
     * @param right
     */
    public DecisionTree(String data, DecisionTree left, DecisionTree right) { 
        super(data, left, right);
    }

    /**
     * 
     * @param data
     * @return
     */
    public DecisionTree followPath(String data) { 
        DecisionTree current = this; 
        for (int i = 0; i < data.length(); i++) { 
            char c = data.charAt(i);
            if (c == 'Y') { 
                current = (DecisionTree) current.getLeft();  
            } else if (c == 'N') { 
                current = (DecisionTree) current.getRight(); 
            } else { 
                return null; 
            }
        }
        return current;
    }

    public static void main(String[] args) {

    // Leaves (animals)
    DecisionTree dog = new DecisionTree("Dog");
    DecisionTree mouse = new DecisionTree("Mouse");
    DecisionTree crocodile = new DecisionTree("Crocodile");

    // Intermediate node
    DecisionTree cat = new DecisionTree("Cat", mouse, null);

    // Question node
    DecisionTree bark = new DecisionTree("Does it bark?", dog, cat);

    // Root
    DecisionTree root = new DecisionTree("Is it a mammal?", bark, crocodile);

    // ---- TESTS ----

    // Direct navigation
    System.out.println(root.getData()); // Is it a mammal?

    System.out.println(root.getLeft().getData()); // Does it bark?
    System.out.println(root.getRight().getData()); // Crocodile

    System.out.println(root.getLeft().getLeft().getData()); // Dog
    System.out.println(root.getLeft().getRight().getData()); // Cat

    System.out.println(root.getLeft().getRight().getLeft().getData()); // Mouse

    // ---- followPath tests ----
    System.out.println(root.followPath("").getData());        // root → Is it a mammal?
    System.out.println(root.followPath("Y").getData());       // Does it bark?
    System.out.println(root.followPath("N").getData());       // Crocodile
    System.out.println(root.followPath("YY").getData());      // Dog
    System.out.println(root.followPath("YN").getData());      // Cat
    try { 
        System.out.println(root.followPath("YNL").getData());     // should break (invalid char)
    } catch (Exception e) { 
        System.out.println("Exception");
    }
    try { 
        System.out.println(root.followPath("YNY"));               // likely null (no right child)
    } catch (Exception e) { 
        System.out.println("Exception");
    }
    

}

}