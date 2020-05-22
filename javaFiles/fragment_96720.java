import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

...

Map<String, Integer> map =
    list.stream()
        .flatMap(m -> m.entrySet().stream())
        .collect(groupingBy(Map.Entry::getKey, summingInt(Map.Entry::getValue)));