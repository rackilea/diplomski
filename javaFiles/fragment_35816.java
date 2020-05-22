import java.util.*;

public class Project {

    public static void main(String[] args) {


        int numValues;         // The number of values user has
        int [] values;         // Array declaration for values


        Scanner keyboard = new Scanner(System.in);             // Scanner object to get input from user

        System.out.println("How many values do you have?");    // To get number of values for array
        numValues = keyboard.nextInt();


        /*
         * Array to hold number of values
         */
        values = new int [numValues];


            /*
             * Loop to gather integer values
             */
        for (int n=0; n < values.length; n++ )
        {

            System.out.print("Enter value " + (n+1) + ":" );
            values[n] = keyboard.nextInt();

        } //End for loop
        System.out.println("Here are the values you've entered" );

        for(int n=0; n<values.length; n++)
        {

            System.out.print(values[n] + " "); 
        }
        System.out.println("Here are the values you've entered, in ascending order");
        sort(values);
        keyboard.close();    // To close Scanner object
    }
            /*
             * Method to arrange values in ascending order
             */



    private static void sort(int[] values) {

        int scan;
        int index;
        int minIndex;
        int minValue;     // Variables to put values in ascending order

        for(scan=0; scan < (values.length-1); scan++)
        {
            minIndex = scan;
            minValue = values[scan];

            for(index = scan+1; index < values.length; index++)
            {
                if(values[index] < minValue)
                {
                    minValue = values[index];
                    minIndex = index;
                } // End if
            } //End for

            values[minIndex] = values[scan];
            values[scan] = minValue;

        } // End for loop

        /*
         * For loop to display values 
         */
        for(int n=0; n < values.length; n++ )
        {
            System.out.print(values[n] + " ");
        } //End for

    } // End method sort
} // End class Project