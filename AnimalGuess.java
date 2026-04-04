import java.util.Scanner;

/** 
 * FileName: AnimalGuess.java
 * Author: Michelle Jiang 
 * Class that implements the animal guessing game. 
 */
public class AnimalGuess { 

    /**
     * Creates a default decision tree for the animal guessing game.
     * @return the root of the default decision tree
     */
    public static DecisionTree defaultTree() { 
        // Leaves (animals)
        DecisionTree dog = new DecisionTree("Dog");
        DecisionTree mouse = new DecisionTree("Mouse");
        DecisionTree crocodile = new DecisionTree("Crocodile");
        DecisionTree cat = new DecisionTree("Cat");

        // Question node
        DecisionTree bark = new DecisionTree("Does it bark?", dog, cat);
        DecisionTree size = new DecisionTree("Is it bigger than a meter?", crocodile, mouse);

        // Root
        DecisionTree root = new DecisionTree("Is it a mammal?", bark, size);
        
        return root; 
    }

    /**
     * Converts user input into a boolean value. Returns true for "yes" and false for "no".
     * @param input the user input to convert
     * @return true if the input is "yes", false if the input is "no", and null for invalid input
     */
    public static Boolean yesNo(String input) { 
        input = input.trim().toLowerCase();
        if (input.equals("y") || input.equals("yes")) { 
            return true; 
        } else if (input.equals("n") || input.equals("no")) { 
            return false;
        } else { 
            return null; 
        }
    }

    /**
     * Prompts the user for input and returns the input as a string.
     * @param prompt the message to display to the user
     * @param scanner the Scanner object to read user input
     * @return the user's input as a string
     */
    public static String getLine(String prompt, Scanner scanner) { 
        System.out.println(prompt);
        String input = scanner.nextLine();
        return input; 
    }

    /**
     * Adds a new question and animal to the decision tree based on user input.
     * @param current the current node in the decision tree where the new question will be added
     * @param newAnimal the name of the new animal to add to the tree
     * @param question the yes/no question that distinguishes the new animal from the old one
     * @param answer the user's answer to the question for the new animal (yes or no)
     */
    public static void addQuestion(DecisionTree current, String newAnimal, String question, String answer) { 
        // Create new nodes
        DecisionTree newAnimalNode = new DecisionTree(newAnimal);
        DecisionTree oldAnimalNode = new DecisionTree(current.getData());
        current.setData(question);
        if (yesNo(answer)) { 
            current.setLeft(newAnimalNode);
            current.setRight(oldAnimalNode);
        } else { 
            current.setLeft(oldAnimalNode);
            current.setRight(newAnimalNode);
        }
    }

    /**
     * Learns a new animal and question from the user when the program fails to guess correctly.
     * @param current the current node in the decision tree where the learning will take place
     * @param scanner the Scanner object to read user input
     */
    public static void learning(DecisionTree current, Scanner scanner) {
        System.out.println("Please help me to learn. What was your animal? ");
        String animal = getLine("Animal:", scanner);
        System.out.println("Type a yes or no question that would distinguish between a " + current.getData() + " and a " + animal);
        String newQuestion = getLine("Question:", scanner);
        String answer = null;
        while (answer == null) { 
            answer = getLine("For a " + animal + ", what would the answer to your question be? (Yes/No):", scanner);
            if (yesNo(answer) != null) { 
                addQuestion(current, animal, newQuestion, answer);
            } else { 
                System.out.println("Invalid input, please try again.");
            }
        }
    }

    /**
     * The main method that runs the animal guessing game.
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        DecisionTree root = defaultTree(); 

        // Main loop
        boolean running = true;  
        System.out.println("Welcome to the Animal Guessing Game! Think of an animal, and I will try to guess it by asking yes or no questions.");
        while (running) {
            DecisionTree current = root; 

            // searching for animal
            while (!current.isLeaf()) { 
                System.out.println(current.getData());
                String answer = getLine("Yes/No:", scanner);
                Boolean yesNoAnswer = yesNo(answer);
                if (yesNoAnswer == null) {
                    System.out.println("Invalid input, please try again.");
                } else if (yesNoAnswer) { 
                    current = (DecisionTree) current.getLeft();
                } else if (!yesNoAnswer) { 
                    current = (DecisionTree) current.getRight();
                } else {
                    System.out.println("Invalid input, please try again.");
                }
            }
            
            // Final guess
            System.out.println("Is your animal a " + current.getData() + "? ");

            Boolean yesNoAnswer = null;

            while (yesNoAnswer == null) {
                String response = getLine("Yes/No:", scanner);
                yesNoAnswer = yesNo(response);

                if (yesNoAnswer == null) {
                    System.out.println("Invalid input, please try again.");
                }
            }

            if (yesNoAnswer) {
                System.out.println("Yay! I guessed right!");
            } else {
                learning(current, scanner);
            }

            // Play again
            System.out.println("Would you like to play again?");

            Boolean again = null;

            while (again == null) {
                String input = getLine("Yes/No:", scanner);
                again = yesNo(input);

                if (again == null) {
                    System.out.println("Invalid input, please try again.");
                }
            }

            if (!again) {
                running = false;
                System.out.println("Thanks for playing!");
            } else {
                System.out.println("Great! Let's play again!");
            }
        scanner.close(); 
        }
    }
}