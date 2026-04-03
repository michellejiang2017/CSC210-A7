import java.util.Scanner;

/** 
 * FileName: AnimalGuess.java
 * Author: Michelle Jiang 
 * Class that implements the animal guessing game. 
 */
public class AnimalGuess { 

    public static DecisionTree defaultTree() { 
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
        
        return root; 
    }

    public static void main(String[] args) {
        // Initialize scanner 
        Scanner scanner = new Scanner(System.in);
        
        DecisionTree root = defaultTree(); 

        // Main loop
        boolean running = true;  
        System.out.println("Welcome to the Animal Guessing Game!");
        while (running) {
            DecisionTree current = root; 

            while (!current.isLeaf()) { 
                //System.out.println(question);
                System.out.println("Y/N:");
                if (scanner.next() == "Y") { 
                    current.getLeft();
                } else if (scanner.next() == "N") { 
                    current.getRight();
                } else { 
                    //throw exception?
                }
            }
            
            System.out.println("Is your animal a " + current.toString() + "? ");
            if (scanner.next() == "Y") {
                System.out.println("Yay! I guessed right!");
            } else if (scanner.next() == "N") { 
                System.out.println("");
            } //bro im too tired for this
            
            //try {
            //    switch (command) {
            //        case "move":
            //            break;
            //            }
            //        default:
            //            System.out.println("Invalid command. Please try again.");
            //        } 
            //    catch (RuntimeException e) {
            //    System.out.println("Error: " + e.getMessage());
            //}
        }

        scanner.close();
    }
}