// Used to capture keyboard input
import java.util.*;

// Our class called SelectionSort
public class SelectionSort {

    // Create doSelectionSort method 
    public static void doSelectionSort(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            // find position of smallest num between (i + 1)th element and last element
            int pos = i;
            for (int j = i; j < arr.size(); j++) {
                if (arr.get(j) < arr.get(pos))
                    pos = j;
            }
            // Swap min (smallest num) to current position on array
            int min = arr.get(pos);
            arr.set(pos, arr.get(i));
            arr.set(i, min);
            printOut(i + 1, arr);
        }
    }

    private static void printOut(int pass, ArrayList<Integer> array) {
        System.out.print("PASS " + pass + ": ");
        for (int i = 0; i < array.size() - 1; i++) {
            System.out.print(array.get(i) + ", ");
        }
        // Shows very last integer with a period
        System.out.print(array.get(array.size() - 1) + "."); 
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>(); // Declare and instantiate a new ArrayList object
        Scanner userChoice = new Scanner(System.in); // User input for quitting program
        String choice = ""; // Will hold user choice to quit program
        boolean inputFlag = false; // True if input is valid, false otherwise

        // Repeat program until user chooses to quit
        while (inputFlag = true) {
            System.out.print("\nWould you like to continue the program? (Y/N): ");
            choice = userChoice.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                try {
                    /* Create an array of size 20 and populate it with random integers between 1 and 1000.
                    Do not ask user for the numbers and do not hard code them */
                    for (int i = 0; i < 20; i++) {
                        int integer = (int)(1000.0 * Math.random());
                        array.add(integer);
                    }
                    System.out.print("\nUNSORTED LIST: ");

                    //Display the 20 size of the unsorted ArrayList 
                    for (int i = 0; i < array.size() - 1; i++) {
                        System.out.print(array.get(i) + ", ");
                    }
                    // Shows very last integer with a period
                    System.out.print(array.get(array.size() - 1) + "."); 
                    System.out.println();
                    doSelectionSort(array);
                }

                catch (IndexOutOfBoundsException e) {
                    System.out.println("\nThere is an out of bounds error in the ArrayList.");
                }
            }
            else if (choice.equalsIgnoreCase("N")) {
                break;
            }
            // Error message when inputting anything other than Y/N
            else { 
                System.out.println("\nERROR. Only Y, y, N, or n may be inputted.");
                System.out.println("Please try again.");
            }
        }
    }
}