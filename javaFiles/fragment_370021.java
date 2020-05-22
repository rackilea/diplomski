import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int value = 0, i;
        char choice = 0;
        boolean valid;
        do {
            valid = true;
            System.out.print("Enter integer: ");
            try {
                value = Integer.parseInt(console.nextLine());
                for (i = 2; i <= Math.sqrt(value); i++) {
                    if (value % i == 0) { // checks if value is evenly divisible by any number
                        System.out.println(value + " is not a prime number ");
                        break;
                    }
                }
                if (i > Math.sqrt(value)) {
                    System.out.println(value + " is a prime number ");
                }
                System.out.print("Would you like to continue y/n: ");
                choice = console.nextLine().charAt(0);
            } catch (NumberFormatException e) {
                System.out.println("This is an invalid input. Try again.");
                valid = false;
            }
        } while (!valid || choice == 'y' || choice == 'Y');
    }
}