// Note that Map.of/List.of require Java 9, but this is not part of the solution
List<Map<String, String>> listOfMaps = List.of(
        Map.of("1", "a1", "2", "a2"),
        Map.of("1", "b1", "2", "b2")
);

final Map<String, List<String>> mapOfLists = listOfMaps.stream()
        .flatMap(map -> map.entrySet().stream())
        .collect(groupingBy(Entry::getKey, mapping(Entry::getValue, toList())));

mapOfLists.forEach((k, v) -> System.out.printf("%s -> %s%n", k, v));