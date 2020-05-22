import java.util.Scanner;
import java.util.Random;
public class RpsLizardSpock {
    public static void main(String[] args) {

        String userChoice;
        boolean goAgain = true;

        Scanner sc = new Scanner(System.in);
        Random ra = new Random();
        while (goAgain) {

            System.out.println("Welcome to Rock, Paper, Scissors, Lizard, Spock\n\n"
                    + "Please make a Choice: ");
            userChoice = sc.next();

            String ucConv = userChoice.toUpperCase();

            System.out.println("You Chose: " + userChoice);

            int cpuChoice = ra.nextInt(5) + 1;

            if ((cpuChoice == 1) && (((ucConv.equals("LIZARD"))) || ((ucConv.equals("SCISSORS"))))) {
                System.out.println("\n\nComputer chose Rock, You Lose");
            } else if ((cpuChoice == 1) && (((ucConv.equals("PAPER"))) || ((ucConv.equals("SPOCK"))))) {
                System.out.println("\n\nComputer chose Rock, You Win");
            } else if ((cpuChoice == 2) && (((ucConv.equals("SPOCK"))) || ((ucConv.equals("ROCK"))))) {
                System.out.println("\n\nComputer chose Paper, You Lose");
            } else if ((cpuChoice == 2) && (((ucConv.equals("SCISSORS"))) || ((ucConv.equals("LIZARD"))))) {
                System.out.println("\n\nComputer chose Paper, You Win");
            } else if ((cpuChoice == 3) && (((ucConv.equals("LIZARD"))) || ((ucConv.equals("PAPER"))))) {
                System.out.println("\n\nComputer chose Scissors, You Lose");
            } else if ((cpuChoice == 3) && (((ucConv.equals("SPOCK"))) || ((ucConv.equals("ROCK"))))) {
                System.out.println("\n\nComputer chose Scissors, You Win");
            } else if ((cpuChoice == 4) && (((ucConv.equals("SPOCK"))) || ((ucConv.equals("PAPER"))))) {
                System.out.println("\n\nComputer chose Lizard, You Lose");
            } else if ((cpuChoice == 4) && (((ucConv.equals("SCISSORS"))) || ((ucConv.equals("ROCK"))))) {
                System.out.println("\n\nComputer chose Lizard, You Win");
            } else if ((cpuChoice == 5) && (((ucConv.equals("ROCK"))) || ((ucConv.equals("SCISSORS"))))) {
                System.out.println("\n\nComputer chose Spock, You Lose");
            } else if ((cpuChoice == 5) && (((ucConv.equals("PAPER"))) || ((ucConv.equals("LIZARD"))))) {
                System.out.println("\n\nComputer chose Spock, You Win");
            } else if ((cpuChoice == 1) && (ucConv.equals("ROCK"))) {
                System.out.println("\n\nComputer chose Rock also, Draw");
            } else if ((cpuChoice == 2) && (ucConv.equals("PAPER"))) {
                System.out.println("\n\nComputer chose Paper also, Draw");
            } else if ((cpuChoice == 3) && (ucConv.equals("SCISSORS"))) {
                System.out.println("\n\nComputer chose Scissors also, Draw");
            } else if ((cpuChoice == 4) && (ucConv.equals("LIZARD"))) {
                System.out.println("\n\nComputer chose Lizard also, Draw");
            } else if ((cpuChoice == 5) && (ucConv.equals("SPOCK"))) {
                System.out.println("\n\nComputer chose Spock also, Draw");
            }
            System.out.println("\n\n Would you like to play again? y/n");
            goAgain = sc.next().charAt(0) == 'y';
        }
    }
}