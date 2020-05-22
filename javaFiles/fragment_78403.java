import java.util.Scanner;
public class CalculatorApp {
    public static void main(String[] args) {
        int choice;
        Scanner in = new Scanner(System.in);
        Calculator calculator = new Calculator();
        while(true) {
            System.out.println("Please choose one of the following options: \n[1] - Set numbers \n[2] - Add Numbers \n[3] - Multiply numbers \n[4] - Exit\nYour choice is: ");  
            choice = in.nextInt();
            switch (choice) {
                case 1:                    
                    System.out.print("\nInput the first number: ");
                    int x = in.nextInt();
                    System.out.print("\nInput the second number: ");
                    int y = in.nextInt();
                    calculator.setNumbers(x, y);
                    break;

                case 2: 
                    int sum = calculator.addNumbers();
                    System.out.println("Sum: " + sum);
                    break;

                case 3:
                    int multiply = calculator.multiplyNumbers();
                    System.out.println("Multiply: " + multiply);
                    break;

                default:
                    System.exit(0);
                }
            }
    }

}