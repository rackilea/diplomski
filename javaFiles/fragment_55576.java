import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * @author Mr__Hamid
 */
public class overFlow {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Map m1 = new HashMap();

        try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                String[] words = line.split(" ");//those are your words
                for (int i = 0; i < words.length; i++) {
                    if (m1.get(words[i]) == null) {
                        m1.put(words[i], 1);
                    } else {
                        int newValue = Integer.valueOf(String.valueOf(m1.get(words[i])));
                        newValue++;
                        m1.put(words[i], newValue);
                    }
                }
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        }
        Map<String, String> sorted = new TreeMap<String, String>(m1);
        for (Object key : sorted.keySet()) {
            System.out.println("Word: " + key + "\tCounts: " + m1.get(key));
        }
    }
}