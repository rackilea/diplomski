package Test;
import java.util.Scanner;

public class TestMain {
    public static void main(String[]args){

        String sentence = getSentence();
        StringBuilder result = new StringBuilder(sentence.length());
        //First one is capital!
        boolean capitalize = true;

        //Go through all the characters in the sentence.
        for(int i = 0; i < sentence.length(); i++) {
            //Get current char
            char c = sentence.charAt(i);

            //If it's period then set next one to capital
            if(c == '.') {
                capitalize = true;
            }
            //If it's alphabetic character...
            else if(capitalize && Character.isAlphabetic(c)) {
                //...we turn it to uppercase
                c = Character.toUpperCase(c);
                //Don't capitalize next characters
                capitalize = false;
            }

            //Accumulate in result
            result.append(c);
        }
        System.out.println(result);
    }

    public static String getSentence(){
        Scanner hold = new Scanner(System.in);
        String sent;
        System.out.print("Enter sentences:");
        sent = hold.nextLine();
        return sent;
    }
}