import java.util.Scanner;

public class DiceGame {
    public static void main(String []args) //main DiceGame loop.
    {
        String answer;
        Scanner stdIn = new Scanner(System.in);
        int userWin = 0, userLose = 0, turnCounter = 0;
        System.out.println("\t" + "Welcome to Computer Dice");
        System.out.println("-----------------------------------------");
        System.out.println("The outcome of your roll will determine" + "\n" + "if you win or lose the round." + "\n");
        System.out.println("Any Quad and you win.");
        System.out.println("Any Triple and you win.");
        System.out.println("Any High Pair and you win.");
        System.out.println("Anything else and you lose.");
        System.out.println("-----------------------------------------");

        do { // I always want the dice to roll unless "n" is selected.

            System.out.println();

            System.out.println("Do you wish to play? [y,n]: ");
            answer = stdIn.next();

            if (answer.equalsIgnoreCase("y")) {

                turnCounter++;

                int d1 = (int)(Math.random() * 4) + 1;
                int d2 = (int)(Math.random() * 4) + 1;
                int d3 = (int)(Math.random() * 4) + 1;
                int d4 = (int)(Math.random() * 4) + 1;

                System.out.println(d1 + "\t" + d2 + "\t" + d3 + "\t" + d4);

                if ((d1 == d2) || (d1 == d3) || (d1 == d4) || (d2 == d3) || (d2 == d4) || (d3 == d4) {
                    userWin++;
                    System.out.println("\n" + "Round Results: Win");
                    System.out.println(turnCounter + " Rounds played.");
                } else {
                    userLose++;
                    System.out.println("\n" + "Round Results: Loss");
                    System.out.println(turnCounter + " Rounds played.");
                }

                System.out.println("Game Results:");
                System.out.println("User won: " + userWin + " Games.");
                System.out.println("User lost: " + userLose + " Games.");

                System.out.println("Your win/loss ratio is: " + userWin + ":" + userLose);

                if (userWin > userLose) {System.out.println("Good Job!");}

                if (userWin < userLose) {System.out.println("You shouldn't bet money on this game...");}

                System.out.println(turnCounter + " Rounds played.");

            }

        } while(answer.equalsIgnoreCase("y"));
    }
}