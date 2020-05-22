import java.util.Scanner;

public class Arrays
{
    public static void main(String[] args)
    {
        //Create a Scanner to read input
        Scanner scan = new Scanner(System.in);

        //Promt the user to enter the array size and store the input
        System.out.println("Enter the size of the array:");
        int arraySize = scan.nextInt();

        //Create an array (For this example we'll use an integer array)
        int[] array = new int[arraySize];

        //Create a for loop to run through array
        for(int i = 0; i < arraySize; i++)
        {
            //Prompt the user to enter a number at the current index (i)
            System.out.println("Enter the element at index " + i + ":");

            //Store the input at index i in the array
            array[i] = scan.nextInt();
        }
    }
}