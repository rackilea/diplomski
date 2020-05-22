import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        System.out.println("Enter  number in range from 1 to 20");
        int n = num.nextInt();
        int product = 1;
        try {
            for (int i = 1; i <= n; i++) {
                product = Math.multiplyExact(product, i);
            }
            System.out.println("Product of numbers between 1 and " + n + " is " + product);
        } catch (ArithmeticException e) {
            System.err.println("Out of Integer boundary");
        }
    }
}