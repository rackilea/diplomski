import java.util.Scanner;

public class Charles_Peppers_Prog6 {

    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);

        // display the welcome / instructions
        System.out.println();
        System.out.println();
        System.out.println("     Welcome to Computer Dice");
        System.out.println("----------------------------------------------");
        System.out.println("You will be playing dice against the computer");
        System.out.println();
        System.out.println("you can only win with a Pair or a Straight");
        System.out.println("any Pair beats any Straight");
        System.out.println("any Pair beats any Junker");
        System.out.println("any Straight beats any Junker");
        System.out.println("in case of two Pairs - high Pair wins");
        System.out.println("in case of two Straights - high Straight wins");
        System.out.println("in case of a tie, you lose");
        System.out.println("----------------------------------------------");
        System.out.println();
        System.out.println();

        // for the two die
        int d1;
        int d2;
        int d3;
        int d4;

        // keep track of results
        int wins = 0;
        int ties = 0;
        int loses = 0;

        // play again response
        String pa = "";

        do {
            // roll the two die
            d1 = (int) (Math.random() * 6) + 1;
            d2 = (int) (Math.random() * 6) + 1;
            d3 = (int) (Math.random() * 6) + 1;
            d4 = (int) (Math.random() * 6) + 1;

            // display the result of the dice roll
            System.out.println(" Player ");
            System.out.println("--------");
            System.out.print("  " + d1 + "  " + d2);
            System.out.print("\n\n");

            System.out.println(" Computer ");
            System.out.println("--------");
            System.out.print("  " + d3 + "  " + d4);
            System.out.print("\n\n");

            // determine if it is a win or a loss
            if (d1 == d2) //Pair
            {
                if (d3 == d4) //computer pair
                {
                    if (d1 > d3) //higher pair
                    {
                        ++wins;
                        System.out.println("Congrats, you win!");
                    }
                    if (d1 < d3) //lower pair
                    {
                        ++loses;
                        System.out.println("Sorry, you lose!");
                    }
                    if (d1 == d3) {
                        ++loses;
                        System.out.println("Sorry, you lose!");
                    }
                } else // only user pair
                {
                    ++wins;
                    System.out.println("Congrats, you win!");
                }
            } else {
                if ((d1 == d2 + 1) || (d1 == d2 - 1)) // Straight
                {
                    if ((d3 == d4 + 1) || (d3 == d4 - 1)) //computer straight
                    {
                        if ((d1 + d2) > (d3 + d4)) {
                            ++wins;
                            System.out.println("Congrats, you win!");
                        }
                        if ((d1 + d2) < (d3 + d4)) {
                            ++loses;
                            System.out.println("Sorry, you lose!");
                        }
                        if ((d1 + d2) == (d3 + d4)) {
                            ++loses;
                            System.out.println("Sorry, you lose!");
                        }
                    }
                    if (d3 == d4) {
                        ++loses;
                        System.out.println("Sorry, you lose!");
                    } else {
                        ++wins;
                        System.out.println("Congrats, you win!");
                    }
                }
                System.out.println();

                // play again question / answer
                do {
                    System.out.print("Do you wish to play again [y, n] : ");
                    pa = user.next();
                } while (!(pa.equalsIgnoreCase("y") || pa.equalsIgnoreCase("n")));

                System.out.println("\n");

                // display final results / report
                System.out.println();
                System.out.println("Computer Dice Results");
                System.out.println("---------------------");
                System.out.println("You played " + (wins + ties + loses) + " rounds");
                System.out.println();
                System.out.println("Rounds won\t:" + wins);
                System.out.println("Rounds lost\t:" + loses);
                System.out.println("---------------------");
                System.out.println();
            }
        } while (pa.equalsIgnoreCase("y"));
        user.close();
    }
}