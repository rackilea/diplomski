import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MatrixSequenceFrequency {
    public static void main(String[] args) {
        int[][] arr1 = new int[][] {
            { 1, 2, 0, 0, 0 },
            { 1, 2, 0, 0, 0 },
            { 0, 0, 3, 4, 5 },
            { 0, 0, 3, 4, 5 },
            { 0, 0, 3, 4, 5 }
        };

        printSequences(findSequences(arr1));

        int[][] arr2 = new int[][] {
            { 1, 2, 3, 0 },
            { 1, 2, 0, 4 },
            { 1, 0, 3, 4 },
            { 0, 2, 3, 4 }
        };

        printSequences(findSequences(arr2));
    }

    private static Map<String, Integer> findSequences(int[][] arr) {
        Map<String, Integer> sequences = new HashMap<String, Integer>();

        for (int i = 0; i < arr.length; i++) {
            indexSequences(arr[i], sequences);
        }

        return sequences;
    }

    private static void indexSequences(int[] arr, Map<String, Integer> sequences) {
        StringBuffer buff = new StringBuffer();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[j] != 0) {
                    buff.append(arr[j]).append(',');
                } else {
                    break; // `0` breaks the sequence.
                }
            }

            if (buff.length() > 0) {
                if (buff.charAt(buff.length() - 1) == ',') {
                    buff.deleteCharAt(buff.length() - 1); // Remove extra comma.
                }

                Integer value = sequences.get(buff.toString());
                sequences.put(buff.toString(), value == null ? 1 : value + 1);
                buff.delete(0, buff.length()); // Clear Buffer
            }
        }
    }

    private static void printSequences(Map<String, Integer> sequences) {
        String format = "%-10s %s%n";
        System.out.printf(format, "Sequence", "Frequency");
        System.out.printf(format, "--------", "---------");
        for (Iterator<Entry<String, Integer>> it = sequences.entrySet().iterator(); it.hasNext();) {
            Entry<String, Integer> entry = it.next();
            System.out.printf(format, entry.getKey(), entry.getValue().toString());
        }
        System.out.println();
    }
}