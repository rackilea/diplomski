import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.Set;
public class RemoveDuplicateWord {
   public static void main(String[] args) {

        String str = "the search engine that could search";
        removeDupWord(str);
    }
public static void removeDupWord(String str) {
    List<String> list = Arrays.asList(str.split(" "));
    Set<String> lhs = new LinkedHashSet<String>(list);
    ArrayList<String> words = new ArrayList<String>();
    for(String s : lhs) {
        words.add(s);
    }
    for(int i=0;i<words.size();i++) {
        System.out.print(words.get(i) + " ");
    }
}
}