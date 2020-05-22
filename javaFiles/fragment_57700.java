import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class AnagramDetector {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("Abc");
        words.add("cba");
        words.add("bca");
        words.add("bc");
        words.add("ba");
        words.add("ab");

        Hashtable<String, List<String>> res = new Hashtable<>();
        words.stream().forEach(word -> {
            String key = getAnagramKey(word);
            List<String> anWords = res.get(key);
            if (anWords == null) {
                anWords = new ArrayList<>();
                res.put(key, anWords);
            }
            anWords.add(word);
        });
        System.out.println(res);
    }
    public static String getAnagramKey(String word) {
        char[] c = word.toLowerCase().toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

}