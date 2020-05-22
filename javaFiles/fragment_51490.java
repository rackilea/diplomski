import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Shifts {

    public static void main(String[] args) {
        LinkedList<Integer> list = Arrays.asList(1, 2, 15, 14, 23)
                .stream().filter(i -> i % 2 != 0)
                .collect(Collectors.toCollection(LinkedList::new));
        int oddCount = list.size();
        String[] results = new String[oddCount];
        IntStream.range(0, oddCount).forEach(index -> {
            Collections.rotate(list, 1);
            results[index] = list.stream()
                             .map(i -> i.toString())
                             .collect(Collectors.joining(","));
        });
        Arrays.asList(results).stream().forEach(System.out::println);
    }

}