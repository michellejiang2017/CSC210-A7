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

    public DecisionTree followPath(String data) { 
        DecisionTree current = this; 
        for (int i = 0; i < data.length(); i++) { 
            char c = data.charAt(i);
            if (current == null) { 
                return null; 
            } else if (c == 'Y') { 
                current = (DecisionTree) current.getLeft();  
            } else if (c == 'N') { 
                current = (DecisionTree) current.getRight(); 
            }
        }
        return current;
    }


}