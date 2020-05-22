import java.util.HashSet;
import java.util.Set;

import org.tartarus.snowball.ext.PorterStemmer;

public class Test {
    public static void main(String[] args) {
        Set<String> stems = new HashSet<>();

        PorterStemmer stemmer = new PorterStemmer();
        String strings[] = new String[] { "I work.", "He works.",
                "I am working.", "I have worked." };
        for (String s : strings) {
            for (String word : s.split("[\\s\\.]+")) {
                stemmer.setCurrent(word);
                stemmer.stem();
                stems.add(stemmer.getCurrent());
            }
        }
        System.err.println(stems);
    }
}