import java.util.Scanner;

public class FibonacciModified {
public static void main(String[] args) {
    System.out.print("This program will print out the ");
    System.out.println("Fibonacci sequence of numbers.");
    System.out.print("\n");
    Scanner keyboard = new Scanner(System.in);
    System.out.println("How many numbers do you want?");
    int numbers = keyboard.nextInt();
    System.out.print("\n");
    int num1 = 0, num2 = 1, num3;
    for (int z = 0; z < numbers; z++) {
        switch (z) {
            case 0:
            System.out.println(num1);
            break;
            case 1:
            System.out.println(num2);
            break;
            default:
            num3 = num1 + num2;
            System.out.println(num3);
            num1 = num2;
            num2 = num3;
            break;
        }
        try {
            Thread.sleep(1000); // 1000 is 1 sec
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
     }
   }
}