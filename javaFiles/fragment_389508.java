import java.nio.file.*;
import java.util.stream.Stream;
import java.util.*;
import java.nio.charset.Charset;

public class Partition2 {
    public static void main(String[] args) {
        String[] input = ...

        try (Stream<String> stream = Arrays.stream(input)) {
            // https://stackoverflow.com/a/34759493/3717691
            String[] array = stream.map(line -> line.trim()).filter(line -> !line.isEmpty()).toArray(String[]::new);

            List<String[]> results = new ArrayList<String[]>();
            String[] tmp = new String[3];
            for (int i = 0; i < array.length; i++) {
                tmp[i % 3] = array[i];
                if (i % 3 == 2) {
                    results.add(tmp);
                    tmp = new String[3];
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}