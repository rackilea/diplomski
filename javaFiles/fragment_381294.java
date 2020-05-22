import java.util.*;

public class RandomGuessMatch
{
   public static void main(String[] args) {
       boolean right = true;
       int MAX = 5;
       int MIN = 1;
       int guess;
       int random;
       Scanner ask = new Scanner(System.in);
           System.out.println("Input your guess between 1 through 5.");
           guess = ask.nextInt();
       random = MIN + (int)(Math.random() * MAX);
       System.out.println("Your guess was " + guess);
       System.out.println("The random number was " + random);
       if (guess == random) {
            right = true;
       } else {
            right = false;
       }
       System.out.println(right);
    }
}