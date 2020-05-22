import java.util.InputMismatchException;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        int x = readNumber();
        int y = readNumber();

        int z;
        z = x + y;

        if (z > 10) {
            System.out.println(z + " is greater than 10");
        } else if (z < 9) {
            System.out.println(z + " is less than 10");
        } else {
            System.out.println(z + " is equal to 10");
        }
    }

    private static int readNumber() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput;
        int result = 0;
        do {
            try {
                System.out.print("Insert a number : ");
                result = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Not a valid number!");
                validInput = false;
                scanner.nextLine(); // to consume the endline character
            }
        } while (!validInput);
        return result;
    }
}