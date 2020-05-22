import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.Arrays;
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

        MultiValueMap<String, String> res = new LinkedMultiValueMap<>();
        words.stream().forEach(word -> {
            String key = getAnagramKey(word);
            res.add(key, word);
        });
        System.out.println(res);
    }
    public static String getAnagramKey(String word) {
        char[] c = word.toLowerCase().toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

}