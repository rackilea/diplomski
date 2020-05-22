import java.util.Scanner;
import java.util.Arrays;

public class Test {

    public static void main ( String args[] ){
        String[] sEnterWord = getSortedWordArr();
        showWordlist(sEnterWord);
        String sWordToChange = getInputFromKeyboard("Which word would you like to change? ");
        System.out.println("You have chosen to change the word : " + sWordToChange);
        changeWordInArray(sWordToChange, sEnterWord);
        Arrays.sort(sEnterWord);
        showWordlist(sEnterWord);
    }

    private static String[] getSortedWordArr(){
        String line = getInputFromKeyboard("How many words are you going to enter? ");
        int length = Integer.valueOf(line);

        String[] sEnterWord = new String[length];

        for(int nCtr = 0; nCtr < length; nCtr++){
            sEnterWord[nCtr] = getInputFromKeyboard("Enter word " + (nCtr+1) + ":");
        }

        Arrays.sort(sEnterWord);

        return sEnterWord;
    }

    private static String getInputFromKeyboard(String prompt){
        System.out.print(prompt);
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();

        return input;
    }

    private static void showWordlist(String[] words){
        System.out.println("Your words are: ");
        for (String w : words){
            System.out.println(w);
        }
    }

    private static void changeWordInArray(String word, String[] array){
        String newWord = getInputFromKeyboard("Enter the new word: ");

        for (int i = 0; i < array.length; i++){
            if (array[i].equals(word)){
                array[i] = newWord;
                break;
            }
        }

        Arrays.sort(array);
    }
}