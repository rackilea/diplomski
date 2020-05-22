import java.util.Scanner;
import java.util.ArrayList;

public class HangmanTest {
    public static void main(String[] args) {

        String[] wordBank = { "madelynn", "crystal", "mcbride", "daughter",
                "adorable", "beautiful", "andrew", "programming", "alyssa",
                "computers", "mcbreezy", "maddy", "happy", "vacation", "beach",
                "java", "benefical", "military", "veteran", "standale",
                "lions", "tigers", "redwings", "pistons", "michigan",
                "football", "baseball", "hockey", "basketball", "golf" };
        int minimum = 0;
        int maximum = wordBank.length - 1;
        String again;

        do {
            int choice = minimum + (int) (Math.random() * maximum);

            String word = wordBank[choice];

            // Converts the random word to asterix
            String userWord = "";
            for (int i = 0; i < word.length(); i++) {
                userWord += "*";

            }

            String guessedLetters="";
            // Breaks into a bunch of characters
            char[] userWordCh = userWord.toCharArray();

            // Show the random word
            System.out.println("The word for you to guess is " + userWord);

            // instantiate a scanner object
            Scanner input = new Scanner(System.in);

            int size = word.length();
            int rightGuesses = 0;
            int wrongGuesses = 0;
            boolean foundLetter;
            char[] wordChars = word.toCharArray();

            guessLoop:
            while (size != rightGuesses) {
                System.out.println("Enter a character: ");
                String response = input.next();
                char ch = response.charAt(0);


                foundLetter=false;
                for (int i=0;i<guessedLetters.size();i++){
                    if (ch == guessedLetters.charAt(i)){
                         System.out.println("Already guessed that letter!");
                         continue guessLoop;
                    }
                }

                guessedLetters+=response;
                for (int i = 0; i < word.length(); i++) {
                    if (wordChars[i] == ch) {
                           foundLetter=true;
                           userWordCh[i] = ch;
                           ++rightGuesses;                            
                    } 
                } // end of for loop
                if(!foundLetter)
                     ++wrongGuesses;
                System.out.print("The word is: ");
                for (int j = 0; j < userWordCh.length; j++)
                    System.out.print(userWordCh[j]);

                System.out.println();
            } // end of while loop

            System.out.println("You had " + wrongGuesses + " wrong guesses.");

            System.out.println("Would you like to play again y/n: ");
            again = input.next();

        } while (again.equals("y"));

    }
}