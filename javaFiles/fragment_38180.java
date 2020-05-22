import java.util.Scanner;
import java.util.InputMismatchException;

class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter any number: ");

        try {
            int num = scan.nextInt();
            if (num > 0) {
                System.out.println(num + " is positive");
            } else if (num < 0) {
                System.out.println(num + " is negative");
            } else if (num == 0) {
                System.out.println(num + " is neither positive nor negative");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Value Must be an integer");
        }

        scan.close();
    }
}