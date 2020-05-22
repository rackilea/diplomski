import java.util.Random;
import java.util.Scanner;
public class Coin {


    // In this block we initialize the global varibales, that can be used and modified by all the methods in the class
    Scanner scanner = new Scanner(System.in);
    private int games = 0;
    private int victories = 0;
    private int rightInputGuess = 0;
    private int wrongInputGuess = 0;
    private int[] items = new int[]{0,1};
    private Random rand = new Random();


      // This method creates the gameheader, meaning it creates a random number and passes it to the game method
      public void initializeGame() {
          System.out.println("Erraten sie, ob Kopf oder Zahl oben liegt:");
          System.out.println("Kopf=0");
          System.out.println("Zahl=1");
          int randomNumber = rand.nextInt(items.length);

          if (randomNumber == 1) {
              rightInputGuess = 1;
              wrongInputGuess = 0;
          } else if (randomNumber == 0) {
              rightInputGuess = 0;
              wrongInputGuess = 1;
          }

          playGame(randomNumber);
      }

      // This method is the actual game logic
      // It takes the generates randomNumber as parameter.
      // if the user types something else as 0 or 1 he will be asked to try to guess the number again.
      public void playGame(int randomNumber) {

          int userInput = scanner.nextInt();
          String play;


          if (userInput == rightInputGuess){
              System.out.println("Sie haben richtig geraten");
              System.out.println("Moechten Sie weiter spielen (yes/no)");
              play = scanner.next();

              if(play.equals("yes")) {
                  victories=victories +1;
                  games = games+1;
                  initializeGame();
              }
              else if (play.equals("no")){
                  victories=victories +1;
                  games = games+1;
                  System.out.println("Sie haben " + games + " Spiele gespielt und " + victories + " Spiele gewonnen");
              }

          } else if (userInput == wrongInputGuess){

              System.out.println("Sie haben falsch geraten");
              System.out.println("Moechten Sie weiter spielen (yes/no)");
              play = scanner.next();

              if(play.equals("yes")) {
                  games = games+1;
                  initializeGame();
              }
              else if (play.equals("no")){
                  games = games+1;
                  System.out.println("Sie haben " + games + " Spiele gespielt und " + victories + " Spiele gewonnen");
              }

          } else if (userInput != 0 || userInput != 1){
              System.out.println("falsche Eingabe, versuchen Sie wieder");
              // The playGame method is called with the current randomNumber.
              // If the user types something else as 0 or 1 he gets the chance to type a valid guess
              playGame(randomNumber);
          }
      }

}