import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Vowels {

  public static final String WORD_FILE = "words.txt";

  public static void main(String[] args) {
    try (Scanner fileScanner = new Scanner(new FileInputStream(WORD_FILE))) {
      String targetWord = null; // word with most consecutive vowels
      int maxConsecutiveVowels = 0;
      while (fileScanner.hasNext()) {
        // for each word in the file
        String word = fileScanner.next().toLowerCase();
        int consecutiveVowels = 0;
        for (int i = 0; i < word.length() && i < word.length() - maxConsecutiveVowels + consecutiveVowels; i++) {
          // for each character in the word, and exit early if the word is not long enough to beat maxConsecutiveVowels
          if (isVowel(word.charAt(i))) {
            // consonants reset this to 0
            consecutiveVowels++;
          } else {
            // reached the end of the vowels so check if we beat maxConsecutiveVowels
            if (consecutiveVowels > maxConsecutiveVowels) {
              maxConsecutiveVowels = consecutiveVowels;
              targetWord = word;
            }
            consecutiveVowels = 0;
          }
        }
        // reached the end of the vowels at the end of the word so check if we beat maxConsecutiveVowels
        if (consecutiveVowels > maxConsecutiveVowels) {
          maxConsecutiveVowels = consecutiveVowels;
          targetWord = word;
        }
      }
      if (targetWord == null) {
        System.out.println("there are no words with vowels in " + WORD_FILE);
      } else {
        System.out.println("the word in " + WORD_FILE + " with the most consecutive vowels is '" + targetWord + "'");
        System.out.println("it has " + maxConsecutiveVowels + " consecutive vowels");
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  private static boolean isVowel(char c) {
    switch (c) {
    case 'a':
    case 'e':
    case 'i':
    case 'o':
    case 'u':
      return true;
    }
    return false;
  }
}