import static java.util.stream.Collectors.*;

...

Map<String, Integer> map = items.stream()
                               .collect(groupingBy(Item::getCode,
                                   summingInt(Item::getQuantity)));