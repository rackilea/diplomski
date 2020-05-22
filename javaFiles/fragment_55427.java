import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
    HashMap<String, Integer> counter = new HashMap<String, Integer>();

    // [... Code to populate hashtable goes here ...]
    // 

    // Extract the map as a list
    List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(counter.entrySet());

    // Sort the list of entries.
    Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
        @Override
        public int compare(Entry<String, Integer> first, Entry<String, Integer> second) {
        // This will give a *positive* value if first freq < second freq, zero if they're equal, negative if first > second.
        // The result is a highest frequency first sort.
        return second.getValue() - first.getValue();
        }
    });

    // And display the results
    for (Map.Entry<String, Integer> entry : entries.subList(0, 10))
        System.out.println(String.format("%s: %d", entry.getKey(), entry.getValue()));
    }

}