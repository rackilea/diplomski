import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

private static double answer;
private static boolean done = false;
private static Scanner in = new Scanner(System.in);

   public static void main(String[] args) {

       try {
           new Calculator().calcExpression();
       } catch (InputMismatchException e) {
           System.out.println("An error occurred. ");
       }
   }

   private void calcExpression() throws InputMismatchException {

       System.out.println("Enter Your Expression Here:");

       System.out.print("Num: ");
       double firstNum = in.nextDouble();
       in.nextLine();

       while (!done) {

           System.out.print("Operator: ");
           String operand = in.nextLine();

           if (operand.equals("=")) {
               break;
           }

           System.out.print("Num: ");
           double secondNum = in.nextDouble();
           in.nextLine();

           calculate(firstNum, operand, secondNum);
           firstNum = answer;
       }

       System.out.printf("Answer is %.2f", answer);
   }

   private void calculate(double num1, String equ, double num2) {

       switch (equ)

       {
           case "/":
               answer = (num1 / num2);
               break;

           case "*":
               answer = (num1 * num2);
               break;

           case "+":
               answer = (num1 + num2);
               break;

           case "-":
               answer = (num1 - num2);
               break;

           case "=":
               done = true;
               break;
       }
   }
}