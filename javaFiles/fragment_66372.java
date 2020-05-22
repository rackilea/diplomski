import java.util.Arrays;
import java.util.Scanner;

public class lowhighavg 
{
    private static int [] array;
    private static int i;

    public static void main(String [] args)
    {
        int numbers[] = new int[10];
        double avg;
        avg = 00;
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++)
        {
            System.out.println("Enter a digit");
            numbers[i]= sc.nextInt();
            avg = avg+numbers[i];
        }

        Arrays.sort(numbers);

        System.out.println("the highest number:" + numbers[numbers.length-1]);
        System.out.println("the lowest number:" + numbers[0]);

        avg =avg/10;

        System.out.println("the average number:" + avg);
    }
}