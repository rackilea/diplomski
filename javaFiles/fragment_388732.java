import java.util.Scanner;

public class SmallestInArray
{
    int index_of_smallest_element;
    public static void main(String[] args) 
    {
        int[] array = new int[10];
        input(array);
        SmallestInArray smallestInArray = new SmallestInArray();
        System.out.printf("Smallest Value:%d corresponding Index:%d\n",smallestInArray.findSmallest(array), smallestInArray.index_of_smallest_element);
        output(array);
    }

    public static void input(int[] array)
    {
        System.out.println("Enter 10 integers: ");
        try (Scanner kybd = new Scanner(System.in))
        {
            for (int i = 0; i < array.length; i++)
            {
                array[i] = kybd.nextInt();
            }
        }
    }

    public int findSmallest(int[] array)
    {
        int smallestValue = array[0];
        index_of_smallest_element = 0;
        for (int i = 1; i < array.length; i++) {
            if (smallestValue > array[i]) // it doesn't accounts for duplicate values
            {
                smallestValue = array[i];
                index_of_smallest_element = i;
            }
        }
        return smallestValue;
    }

    public static void output(int[] array)
    {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
    }}