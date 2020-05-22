public class ChoHan {

public static void main(String[] args) {

    final int MAX_ROUNDS = 5;
    String player1Name;
    String player2Name;

    Scanner keyboard = new Scanner(System.in);

    char repeat;
    do
    {
        System.out.println(" Enter the first player name :");
        player1Name = keyboard.nextLine();
        System.out.println("Enter the second player name :");
        player2Name = keyboard.nextLine();

        Dealer dealer = new Dealer();

        Player player1 = new Player(player1Name);
        Player player2 = new Player(player2Name);

        for (int round = 0; round < MAX_ROUNDS; round++) {
            System.out.println("-----------------------");
            System.out.printf(" Now playing round %d.\n", round + 1);

            dealer.RollDice();

            player1.makeGuess();
            player2.makeGuess();

            roundResult(dealer, player1, player2);
        }

        displayGrandWinner(player1, player2);

        System.out.println(" Would you like to play again ?");
        System.out.println(" Enter y for yes or n for no ");
        String input = keyboard.nextLine();
        repeat = input.charAt(0);
    } while (repeat == 'Y' || repeat == 'y');

}

public static void roundResult(Dealer dealer, Player player1, Player player2) {
    System.out.printf(" The dealer roll %d and %d.\n", dealer.getDie1Value(),
            dealer.getDie2Value());
    System.out.printf("Results : %s\n", dealer.getchorOrHan());

    checkGuess(player1, dealer);
    checkGuess(player2, dealer);
}

public static void checkGuess(Player player, Dealer dealer) {
    final int POINTS_TO_ADD = 1;
    String guess = player.getGuess();
    String choHanResult = dealer.getchorOrHan();

    System.out.printf("The Player %s guessed %s.\n", player.getName(),
            player.getGuess());

    if (guess.equalsIgnoreCase(choHanResult)) {
        player.addPoints(POINTS_TO_ADD);
        System.out.printf("Awarding %d points(s)to %s\n", POINTS_TO_ADD,
                player.getName());
    }
}

public static void displayGrandWinner(Player player1, Player player2) {


    System.out.println("--------------------------");
    System.out.println(" Game over !. Here are the results:");
    System.out.printf("%s : %d points.\n", player1.getName(), player1.getPoints());
    System.out.printf("%s : %d points.\n", player2.getName(), player2.getPoints());

    if (player1.getPoints() > player2.getPoints())
        System.out.println(player1.getName() + " is the Grand Winner!");
    else if (player2.getPoints() > player1.getPoints())
        System.out.println(player2.getName() + " is the Grand Winner!");
    else
        System.out.println(" Both players are tied!");


  }
}