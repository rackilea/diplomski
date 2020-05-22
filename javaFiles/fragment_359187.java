import java.util.Scanner;

/**
 *
 * @author Tyler Weaver
 */
public class Test {
    public static void main(String[] args) {
        String play = "yes";
        int cash;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.printf("Enter cash amount: ");
            cash = scan.nextInt();
        } while (cash < 1);

        DiceGame game = new DiceGame(cash);

        while (play.equalsIgnoreCase("yes") && cash > 0) {
            int dice1 = game.roll();
            int dice2 = game.roll();

            game.calcCash(dice1 + dice2);
            cash = game.getCash();
            System.out.printf("Your new cash amount is $%,.2f%n", (float) cash);
            System.out.printf("Do you want to play again? ");

            play = scan.next();
        }
    }
}