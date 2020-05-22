package week5;

import java.util.Arrays;

/**
 *
 * @author meowens
 */
public class Week5 {

    /**
    * @param args the command line arguments
    */

    public static void selectionSort( double [] numberList)
    {
        double temp; 
        int max;

        for (int i = 0; i < numberList.length - 1; i++)  
        {
            max = indexOfLargestElement( numberList, numberList.length - i);

            temp = numberList[max];
            numberList[max] = numberList[numberList.length - i - 1];
            numberList[numberList.length - i - 1] = temp;
        }
    }

    private static int indexOfLargestElement( double [] numberList, double size )
    {
        int index = 0;
        for ( int i = 1; i < size; i++)
        {
            if (numberList[i] > numberList[index] )
                index = i;
        }
        return index;
    }

    public static void insertionSort ( double [] numberList)
    {
        int j;
        double temp;

        for ( int i = 1; i < numberList.length; i++ )
        {
            j = i;
            temp = numberList[i];

            while ( j != 0 && numberList[j - 1] > temp )
            {
                numberList[j] = numberList[j - 1];
                j--;
            }

            numberList[j] = temp;
        }
        // TODO code application logic here

        // assigning values
        numberList[0] = 53.5;
        numberList[1] = 60.3;
        numberList[2] = 96.2;
        numberList[3] = 53.3;
        numberList[4] = 56.4;
        numberList[5] = 52.7;
        numberList[6] = 76.4;
        numberList[7] = 77.5;
        numberList[8] = 71.0;
        numberList[9] = 78.2;

        numberList[10] = 65.2;
        numberList[11] = 59.3;
        numberList[12] = 80.5;
        numberList[13] = 92.1;
        numberList[14] = 85.7;
        numberList[15] = 78.7;
        numberList[16] = 66.2;
        numberList[17] = 88.8;
        numberList[18] = 50.2;
        numberList[19] = 73.4;
    }
}