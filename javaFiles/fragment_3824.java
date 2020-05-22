import java.util.Scanner;

public class Factorial {
public static void main(String[] args) {

    System.out.print("Enter a non-negative number that you wish to perform a factorial function on: ");

    //Create scanner object for reading user input
    Scanner input = new Scanner(System.in);

    //Declare variables
    int number = input.nextInt();
    int factTotal = 1;

    if(number > 0){

        factTotal = factorial(number);

        System.out.print(factTotal);
   }
   else
       System.out.println("This is a negative number");
}