import java.io.*;
import java.util.*;

public class InputStats {
    // *** I added this to help your while loop ***
    public static boolean isInteger(String s) {
        // check if a string is an integer, eg "10" is 10 but "w" is not an int
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner TextIO = new Scanner(System.in);

        // *** I added this to store the input as a string first ***
        String input;        // The original string inputted by the user

        int inputNumber;     
        int sum;             
        int count;           
        double mean;         
        int squarein;        
        int sumsquare;       
        double meansquare;   

        sum = 0;
        count = 0;
        sumsquare = 0;
        meansquare = 0;

        System.out.println("Enter your first positive integer: ");

        // *** I changed this to .nextLine(); to get a string ***
        input = TextIO.nextLine();

        // *** I made this while it's an integer so it stops when it's a string ***
        while (isInteger(input)) {
            inputNumber = Integer.parseInt(input);
            sum += inputNumber;
            squarein =  inputNumber; 
            sumsquare = squarein * squarein; 
            count++;              
            System.out.println("Enter your next positive integer, or a non integer to end: ");

            // *** I changed this to .nextLine(); to get a string ***
            input = TextIO.nextLine();
        }

        if (count == 0) {
            System.out.println("You didn't enter any data!");
        }
        else {
            mean = ((double)sum) / count;
            meansquare = ((double)sumsquare) / count;

            // *** I removed this because it was no longer needed *** TextIO.nextInt();

            System.out.println("Numbers entered: " + count + "\n");
            System.out.println("Sum: " + sum + "\n");
            System.out.println("Mean: " + mean + "\n");
            System.out.println("Sum Squares: " + sumsquare + "\n");
            System.out.println("Mean Square: " + meansquare + "\n");
        }

    } // end main()

} // end class InputStats