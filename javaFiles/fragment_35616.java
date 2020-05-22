List<Map<String, List<String>>> input = ...;

Set<String> output = input.stream()    // -> Stream<Map<String, List<String>>>
    .map(Map::values)                  // -> Stream<List<List<String>>>
    .flatMap(Collection::stream)       // -> Stream<List<String>>
    .flatMap(Collection::stream)       // -> Stream<String>
    .collect(Collectors.toSet())       // -> Set<String>
    ;