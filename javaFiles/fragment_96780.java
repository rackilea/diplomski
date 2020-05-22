import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int number, guess, tryCount, replay;
    public static int maxValue = 1;
    public static Scanner scan;
    public static Random rand;

    public static void main(String args[]) {
        scan = new Scanner(System.in);
        rand = new Random();
        do { // start of do-while loop
            tryCount = 0; // reset tryCount
            System.out.print("Enter a maximum number: ");
            while(maxValue < 2) {
                maxValue = scan.nextInt();
            }
            number = rand.nextInt(maxValue);
            System.out.print("Guess a number from 1 to " + maxValue + ": ");
            while (guess != number) {
                guess = scan.nextInt();
                tryCount++;
                if (guess < 1) {
                    System.out.print("Guess is not positive. Try again: ");
                } else if (guess < number) {
                    System.out.print("Too low! Try again: ");
                }
                if (guess > maxValue) {
                    System.out.println("Guess is higher than " + maxValue + ". Try again: ");
                } else if (guess > number) {
                    System.out.print("Too high! Try again: ");
                }
            }
            if (tryCount == 1) {
                System.out.println("Nailed it! It only took you 1 try!");
            } else {
                System.out.println("Nailed it! It took you " + tryCount + " tries.");
            }

            do { // check the user's input
                System.out.println("Type 0 to play again. Type 1 to quit.");
                replay = scan.nextInt();
                if (replay != 0 && replay != 1) {
                    System.out.println("Input not recognized.");
                }
            } while (replay != 0 && replay != 1);
        } while (replay == 0); // end of do-while loop
    }
}