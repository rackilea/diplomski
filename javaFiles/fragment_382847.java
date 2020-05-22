public static List<String> removeDuplicateNames(String... namesArray) {
    return Stream.of(namesArray)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet().stream()
            .filter(e -> e.getValue() == 1)
            .map(Entry::getKey)
            .collect(Collectors.toList());
}