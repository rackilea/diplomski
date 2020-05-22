import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Aditya on 14-10-2014.
 */
public class Main {

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        ArrayList<String> lines = new ArrayList<String>();
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<String> words_2 = new ArrayList<String>();
        boolean once_entered = true;
        for (int i = 0; i < n; i++) {
            lines.add(i, scan.nextLine() + " ");
        }
        for (int i = 0; i < n; i++) {
            String word = "";
            for (int j = 0; j < lines.get(i).length(); j++) {
                char char_0 = lines.get(i).toLowerCase().charAt(j);
                if ((int) (char_0) >= (int) ('a') && (int) (char_0) <= (int) ('z')) {
                    word += char_0;
                    once_entered = false;
                } else if (!once_entered) {
                    words.add(word);
                    word = "";
                    once_entered = true;
                }
            }
        }
        for (int i = 0; i < words.size(); i++) {
            boolean contains =false;
            for(int j=0;j<words_2.size();j++){
                if(words_2.get(j).contentEquals(words.get(i)))
                    contains=true;
            }
            if(!contains)
                words_2.add(words.get(i));
        }
        Collections.sort(words_2);
        System.out.println(words_2.size());
        for (int i = 0; i < words_2.size(); i++) {
            System.out.println(words_2.get(i));
        }
    }
}