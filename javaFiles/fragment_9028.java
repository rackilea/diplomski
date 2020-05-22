import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Occurances
{
    public static void main(String[] args)
    {
        int numNums = 5;

        int[][] num = new int[numNums][2];

        Scanner keyboard = new Scanner(System.in);
        for (int i=0; i<numNums; i++)
        {
            System.out.println("Enter the "+i+"th number:");
            num[i][0] = keyboard.nextInt();
            //num[i][0] = (i*i)%numNums;
            //System.out.println("Number "+i+" is "+num[i][0]);
        }
        keyboard.close();

        sort(num, 0);

        int maxOccurrences = -1;
        for (int i=0; i<numNums; i++)
        {
            num[i][1] = computeFrequency(num[i][0], num, 0);

            maxOccurrences = Math.max(maxOccurrences, num[i][1]);
        }

        System.out.println("maxOccurrences "+maxOccurrences);

        int sum = computeSum(num, 0);
        int avg = sum / numNums;
        int max = computeMax(num, 0);
        int min = computeMin(num, 0);

        System.out.println(" ");
        System.out.println("Sum:" + sum);
        System.out.println("Avg:" + avg);
        System.out.println("Max:" + max);
        System.out.println("Min:" + min);
        System.out.println("Median:" + num[numNums/2][0]);
        System.out.println("Mode:" + min);
    }

    private static int computeSum(int array[][], int column)
    {
        int sum = 0;
        for (int i=0; i<array.length; i++)
        {
            sum += array[i][column];
        }
        return sum;
    }

    private static int computeMin(int array[][], int column)
    {
        int min = Integer.MAX_VALUE;
        for (int i=0; i<array.length; i++)
        {
            min = Math.min(min, array[i][column]);
        }
        return min;
    }

    private static int computeMax(int array[][], int column)
    {
        int max = Integer.MIN_VALUE;
        for (int i=0; i<array.length; i++)
        {
            max = Math.max(max, array[i][column]);
        }
        return max;
    }

    private static void sort(int array[][], final int column)
    {
        Arrays.sort(array, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] a0, int[] a1)
            {
                return Integer.compare(a0[column], a1[column]);
            }
        });
    }

    private static int computeFrequency(int value, int array[][], int column)
    {
        int count = 0;
        for (int i=0; i<array.length; i++)
        {
            if (array[i][column] == value)
            {
                count++;
            }
        }
        return count;
    }


}