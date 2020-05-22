import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Not great code; it just illustrates an idea.
 */
public class SortExample {

    /**
     * Shows how to sort an array based on the way a "companion" list
     * would sort.  <strong>ASSUMPTION</strong>: The values in the companion
     * list must be unique!
     */
    public static void main(String[] args) {

        String[] names = {"two", "seven", "six", "eight", "one"};
        List<Integer> numbers = Arrays.asList(2, 7, 6, 8, 1);

        // Note: This only works if names and numbers are the same size....
        SortedMap<Integer, String> pairs = new TreeMap<Integer, String>();
        for (int i = 0; i < names.length; i++) {
            pairs.put(numbers.get(i), names[i]);
        }

        // Note: This destroys the original array
        int i = 0;
        for (Map.Entry<Integer, String> e : pairs.entrySet()) {
            names[i++] = e.getValue();
        }

        System.out.println(Arrays.toString(names));
    }
}