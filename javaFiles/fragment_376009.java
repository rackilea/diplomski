import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;

import static java.util.stream.Collectors.*;

public class Use {

    public static void main(String[] args) {
        Map<String, String> m1 = new HashMap<>();
        m1.put("color", "red");
        m1.put("size", "small");
        m1.put("volume", "low");

        Map<String, String> m2 = new HashMap<>();
        m2.put("color", "red");
        m2.put("size", "small");
        m2.put("volume", "medium");

        Map<String, String> m3 = new HashMap<>();
        m3.put("color", "blue");
        m3.put("size", "small");
        m3.put("volume", "high");

        List<Map<String, String>> listOfMaps = Arrays.asList(m1, m2, m3);

        Map<String, Map<String, Long>> occurences = compute(listOfMaps, counting());
        Map<String, Map<String, Double>> frequencies = compute(listOfMaps, collectingAndThen(counting(), l -> (double)l / listOfMaps.size()));

        System.out.println(occurences); //prints {volume={high=1, low=1, medium=1}, size={small=3}, color={red=2, blue=1}}
        System.out.println(frequencies); //prints {volume={high=0.3333333333333333, low=0.3333333333333333, medium=0.3333333333333333}, size={small=1.0}, color={red=0.6666666666666666, blue=0.3333333333333333}}

    }

    private static <T> Map<String, Map<String, T>> compute(List<Map<String, String>> data, Collector<Entry<String, String>, ?, T> finalComputation) {
        return data.stream()
                    .flatMap(m -> m.entrySet().stream())
                    .collect(groupingBy(Entry::getKey,
                             groupingBy(Entry::getValue, finalComputation)));
    }
}