import java.util.Scanner;//Import Scanner class to read a file in the computer
import java.io.File;//Import File class to read a file in the computer
import java.io.FileNotFoundException;//Import FileNotFoundException class if case file is not found in the computer

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*; // Import all java utilities


public class assignmentTwo {
    public static ArrayList<Integer> nums;

    public static void main(String[] args) throws FileNotFoundException{

        int count = 0;


        //Display each word in INPUT_TEXT
        Scanner INPUT_TEXT = new Scanner(new File("/Users/Matt/Desktop/assignment2.csv"));//Create a Scanner Class and File Class to read a file from your computer.


        INPUT_TEXT.useDelimiter(" ");//Divide DemoData.txt into several pieces by a space

        // test to see if file was received
        if (INPUT_TEXT != null) {

            System.out.println(INPUT_TEXT);

        }


        while(INPUT_TEXT.hasNext()){


            //Read each word
            String TempString = INPUT_TEXT.next();

            //Display all numbers.Eliminate comma, e.g., 1,200 -> 1200
            String temp1 = TempString.replaceAll("[\\,]", "");//Create a String class temp1 that eliminates comma.
            String pattern1 = "[0-9]+";//Create a String class pattern1 that stores the Regular Expression to match numbers.
            Pattern r1 = Pattern.compile(pattern1);//Create Pattern class to compile pattern1.
            Matcher m1 = r1.matcher(temp1);//Match each piece with the Regular Expression


            // array variable
            nums = new ArrayList<Integer>();

            // find values that match
            if (m1.find( )) {

            // parse array values from string to integers
            int parsedNum = Integer.parseInt(m1.group());
            nums.add(parsedNum);


            //If a number is matched, print the number.
            System.out.print(m1.group() + " ");

            // increment counter when number validation is reached
            count++;


            // if count reaches 5, reset count and print new line
            if (count == 5) {

            count = 0;

            System.out.println();



    }

    // run isPrime method
     isPrime();

}

    }

        INPUT_TEXT.close();//Close your Scanner.

    }

    // isPrime method to test which #s are prime
    public static int isPrime(){

        // finds size of array
        for(int s = 0; s < nums.size(); s++){

            // primeNum is true by default
            boolean primeNum = true;

            /* if a value from the array is divisible by any # <= array value
                then that value is not prime */
            for (int divisor = 2; divisor <= nums.get(s) / 2; divisor++) {
                if (nums.get(s) % divisor == 0) {

                    primeNum = false;

                }

            }
                // if value is prime, print out current value 
                if (primeNum) {

                    //System.out.println();
                    System.out.print(nums.get(s) + " ");

                    // return array list values
                    return nums.get(s);

                }

        }

        // exit status
        return 0;
    }    
}