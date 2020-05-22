import java.util.InputMismatchException;
import java.util.Scanner;

public class DeepbotCalc {

    public static void main(String[] args) {
        Scanner input;

        int points = 0;
        boolean error1 = false;

        do {

            try {
                input = new Scanner(System.in);
                System.out.println("How many points do you currently have?");
                points = input.nextInt();


                if (points >= 2) {
                    error1 = false;
                }

                else if (points > 0 && points < 2) {
                    System.out.println("you need at least 2 points");
                    error1 = true;
                }

                else if (points <= 0) {
                    System.out.println("Please enter a positive whole number");
                    error1 = true;
                }

            }

            catch (InputMismatchException e) {
                System.out.println("Please enter a positive whole number.");
                error1 = true;
            }

        } while (error1);
    }
}