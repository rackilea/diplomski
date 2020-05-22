import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class StackOverflow {

@SuppressWarnings("unchecked")
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Map<String, Integer> countedWords = new HashMap<String, Integer>();
    int numberOfWords = 0;
    String word = "";
    while (true) {
        word = scanner.nextLine();
        if (word.equalsIgnoreCase("-1")) {
            break;
        }
        if (countedWords.containsKey(word)) {
            numberOfWords = countedWords.get(word);
            countedWords.put(word, ++numberOfWords);
        } else {
            countedWords.put(word, 1);
        }
    }
    Iterator it = countedWords.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry pairs = (Map.Entry)it.next();
        System.out.println(pairs.getKey() + " = " + pairs.getValue());
    }
}
}