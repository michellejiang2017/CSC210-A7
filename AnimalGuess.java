import java.util.Scanner;

/** 
 * FileName: AnimalGuess.java
 * Author: Michelle Jiang 
 * Class that implements the animal guessing game. 
 */
public class AnimalGuess { 

    public static void main(String[] args) {
        // Initialize scanner 
        Scanner scanner = new Scanner(System.in);

        // Main shopping loop
        boolean shopping = true;  
        while (shopping) {
            System.out.print("\nEnter your choice: ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ", 2);
            String command = parts[0].toLowerCase();

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