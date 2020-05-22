import java.util.Scanner; 
import java.util.Random; 


public class Dice
{ 
    private static void play(Scanner scan, Random generator)
    {
        int computersPlay, usersPlay;

        System.out.println("Let's play some dice!");
        computersPlay = generator.nextInt(6) + 1;

        System.out.print("Give a number:");
        usersPlay = scan.nextInt();

        System.out.printf("The dice rolled %d\n", computerPlay);

        if (computersPlay == usersPlay) {
            System.out.println("You win !");
        }
        else {
            System.out.println("You lose!");
        }
    }

    public static void main(String[] args) 
    { 
        Scanner scan      = new Scanner(System.in);
        Random  generator = new Random();

        do {
            play(scan, generator);
            System.out.println("If you want to continue type:'Reset'");
        } while(scan.next().equals("Reset");
    }
}