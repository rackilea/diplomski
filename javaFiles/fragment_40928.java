import java.util.Scanner;

public class Divide {
    public static void main(String[] args) {

        int num1 = 0;
        int num2 = 0;
        double ratio;
        Scanner scan = new Scanner(System.in);
        int x = 1; // using variable for do-while loop

        do { // re-runs code if input error
            try {
                System.out.println("Let's divide some numbers!");
                System.out.print("Enter your first number: ");
                num1 = scan.nextInt();
                System.out.print("Enter your second number: ");
                num2 = scan.nextInt();
                if (num2 != 0) {
                    ratio = ((double) num1 / num2);
                    System.out.println("Eureka!  the answer is " + ratio);
                } else {
                    System.out.println("The second number should not be 0");
                }
            } catch (Exception e) {
                System.out.println("This won't work. Try again.");
                scan = new Scanner(System.in);
            }
        } while (x == 1);
    }
}