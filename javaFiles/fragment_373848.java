import java.util.Scanner;

public class BasicCalculator {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    double firstNumber = 0.0;
    double secondNumber = 0.0;

    //New variable
    int errors = 0;

    while (errors < 3) {
        System.out.println("MENU");
        System.out.println("1. +");
        System.out.println("2. -");
        System.out.println("3. *");
        System.out.println("4. /");
        System.out.println("5. Generate a random number.");
        System.out.println("6. Quit");

        System.out.println("What would you like to do?");
        System.out.print("> ");
        int menuSelect = input.nextInt();
        //Selects an item from the menu

        if(menuSelect == 1 || menuSelect == 2 || menuSelect == 3 || menuSelect == 4) {
            errors = 0;
            System.out.print("Enter first number: ");
            firstNumber = input.nextDouble();
            //Stores input as the firstNumber

            System.out.print("Enter second number: ");
            secondNumber = input.nextDouble();
            //Stores input as the secondNumber
        }
        if(menuSelect == 1){
            System.out.println(firstNumber + secondNumber);
            //Adds two numbers
        }
        else if(menuSelect == 2){
            System.out.println(firstNumber - secondNumber);
            //Subtracts second number from first number
        }
        else if(menuSelect == 3){
            System.out.println(firstNumber * secondNumber);
            //Multiplies two numbers
        }
        else if(menuSelect == 4){
            if(secondNumber != 0){
                System.out.println(firstNumber / secondNumber);
                //Divides first number by second number
            }
            else if(secondNumber == 0){
                System.out.println("I'm sorry, you cannot divide by zero.");
            }
        }
        else if(menuSelect == 5){
            errors = 0;
            System.out.print("Enter upper limit: ");
            firstNumber = input.nextDouble();
            System.out.print("Enter lower limit: ");
            secondNumber = input.nextDouble();
            double randomVal = (firstNumber + (int)(Math.random() * ((firstNumber - secondNumber)+1)));
            System.out.println(randomVal);
            //Displays a random integer between an upper and a lower limit
        }
        else if (menuSelect==6){
            System.out.println("Goodbye");
            System.exit(0);
        }
        else{
            errors++;
            System.out.println("Sorry, "+ menuSelect + " is not an option.");
        }
    }       
    input.close();
    System.out.println("Program will exit now");
  }
}