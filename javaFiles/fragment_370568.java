import java.util.*;

public class HDtest9 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) { // have created infinite loop
            System.out.print("Enter text: ");
            String sentence = in.nextLine();
            System.out.println("You have entered: " + sentence); // to Print string
            System.out.println("The total number of characters is " + sentence.length()); // to print Entered string's length
            System.out.println("This piece of text has " + countWords(sentence) + " words.");

            if (sentence.equals("quit")) { // if enterd value is "quit" than it comes out of loop
                break;
            } else {

                String[] words = sentence.split(" "); // get the individual words

                int maxWordLength = 0;
                int wordLength = 0;
                for (int i = 0; i < words.length; i++) {

                    wordLength = words[i].length();
                    if (wordLength > maxWordLength) {
                        maxWordLength = wordLength;
                    }
                }
                int[] intArray = new int[maxWordLength + 1];
                for (int i = 0; i < words.length; i++) {
                    intArray[words[i].length()]++;
                }
                for (int i = 1; i < intArray.length; i++) {
                    System.out.printf("%d word(s) of length %d<br>", intArray[i], i);
                }

                for (int i = 0; i < words.length; i++) {
                    System.out.println("word " + i + ": " + words[i] + " = " + words[i].length() + " characters");
                }

            }

        }
        in.close();
    }

    private static int countWords(String str) {
        String words[] = str.split(" ");
        int count = words.length;
        return count;
    }

}