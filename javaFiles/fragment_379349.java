import java.util.Scanner;

public class PrintDigits {
public static void main(String [] args) {
   Scanner scnr= new Scanner(System.in);
   int userInput = 0;
   int positiveInt = 0;

    System.out.println("enter a positive integer:");
    userInput = scnr.nextInt();

    positiveInt = userInput % 10;
    System.out.println(positiveInt);

    scnr.close();
    return;
    }
}