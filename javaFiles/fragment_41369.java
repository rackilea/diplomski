import java.util.HashMap;
import java.util.Scanner;

public class test {
    public static void main( String[] args ){
        String sWord= new String();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Word");
        sWord = input.nextLine();

        HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();

        for(Character c : sWord.toCharArray()) {
            if(charCount.containsKey(c)) {
                charCount.put(c, charCount.get(c)+1);
            } else {
                charCount.put(c, 1);
            }
        }

        for(Character key : charCount.keySet()) {
            System.out.print(key + ":" + charCount.get(key) + " ");
        }
    }
}