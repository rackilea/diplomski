import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingDemo {

    public static void getColdSearch(String[] inArray) {
        Map<String, Long> groupingByLetter = Arrays.stream(inArray)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<String> result = groupingByLetter.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .limit(5)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());

        System.out.println(result);
    }

    public static void main(String[] args) {
        String inStrings[] = {"A", "B", "C", "D", "E", "F", "G", "H", "A", "B", "C", "D", "E", "A", "B", "C", "D", "A", "B"};
        getColdSearch(inStrings);
    }
}