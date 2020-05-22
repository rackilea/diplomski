import java.util.*;

public class SumInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double data = 1.0;
        double sum = 0.0;
        boolean valid = false;
        while (!valid) {
            try {
                while (true) {
                    System.out.print("So far, sum = " + sum
                            + "\nEnter a number or 0 to exit: ");
                    data = input.nextDouble();
                    sum = sum + data;
                    valid = true;
                    if (data == 0.0) {
                        break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Error--please enter a double number");
                input.next();
            } catch (NoSuchElementException e) {
                System.out.println("\nGoodbye!");
                System.exit(0);
            }
        }
        System.out.println("Ending sum: " + sum);
    }
}