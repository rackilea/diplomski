import java.util.Scanner;

public class GuessNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name:");
        if (sc.hasNextLine()) {
            String userName = sc.nextLine();
            System.out.println("Hello " + userName + ",");
            System.out.println();
        }

        int secretNum = 5;
        int secretNum2 = 15;
        int guess = 0;

        System.out.println("Guess what is the number 0 to 10: ");

        if (sc.hasNextInt()) {
            guess = sc.nextInt();
        }

        while (secretNum != guess) {
            System.out.println("Please try again\n");
            if (sc.hasNextInt()) {
                guess = sc.nextInt();
            }

        }
        System.out.println("Well done\n");
        System.out.println("Are you ready for the next step?\n");

        System.out.println("Enter Yes or No");
        while (!sc.next().equals("yes") && !sc.next().equals("no"))
        {
            System.out.print("Yes");
        }

        System.out.println("Guess what is the number 11 to 20: ");

        if (sc.hasNextInt()) {
            guess = sc.nextInt();
        }

        while (secretNum2 != guess) {
            System.out.println("Please try again\n");
            if (sc.hasNextInt()) {
                guess = sc.nextInt();
            }

        }

        System.out.println("Congratulations");
        System.out.println();
        System.out.println("The End");

    }
}