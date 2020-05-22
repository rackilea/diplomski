import java.util.Scanner;
import java.io.*;
import java.text.DecimalFormat;

public class hw {

public static void main(String[] args) {

    int maxGrade = Integer.MIN_VALUE;
    int minGrade = Integer.MAX_VALUE;
    int count = 0;
    int total = 0;
    final int SENTINEL = -1;
    int score;

    Scanner scan = new Scanner(System.in);

    System.out.println("To calculate the class average, enter each test score.");
    System.out.println("When you are finished, enter a -1.");

    System.out.print("Enter the first test score > ");
    score = scan.nextInt();


    while (score != SENTINEL) 
    {

        if (score < 0 || score> 100)
        {
            System.out.print("ERROR: Not a valid test score. ");
        }
        else
        {
            //add one to the count
            count++;
            //calculate the maximum and the minimum
            if (score > maxGrade) {
                maxGrade = score;
            }
            if (score < minGrade) {
                minGrade = score;
            }
            total += score;
        }
        System.out.println(" Enter the next test score > ");
        score = scan.nextInt();

    }
    if (count != 0) {
        DecimalFormat oneDecimalPlace = new DecimalFormat("0.0");

        System.out.println("\nThe class average is "
                + oneDecimalPlace.format((double) (total) / count));
        System.out.println("The minimum value is " + minGrade);
        System.out.println("The maximum value is " + maxGrade);
    } else {
        System.out.println("\nNo grades were entered");
    }

}
}