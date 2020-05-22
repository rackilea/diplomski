import java.util.Scanner;

public class NumberScanner {

    private static final int MAX_SIZE = 20;

    static int[] intArray = new int[MAX_SIZE];

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        int value = 0;
        int size = 0; // Not an array counter, starts at 1. 0 means empty.

        System.out.println("Enter a series of positive integers on one or more lines. Enter a negative number to quit.");

        // Loop until a negative number is found or the MAX_SIZE is reached
        while (size < MAX_SIZE) {
            value = keyboard.nextInt();
            if (value < 0)
                break;

            boolean found = false;
            if (value >= 0 && size > 0) {
                // Add the value to the array
                // First, check if its already there
                for (int i = 0; i<size; i++) {
                    if (intArray[i] == value) {
                        found = true;
                        break;  // Stop the loop
                    }                   
                }
            }
            if (!found) {               
                intArray[size] = value;
                size++;
            }
        }

        for (int i=0; i<size; i++) {
            System.out.printf(intArray[i] + " ");
        }
        System.out.printf("\n");

        keyboard.close();
    }
}