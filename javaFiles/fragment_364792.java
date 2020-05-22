public Map<String, List<String>> weirdMapFunction(List<Map<String, String>> inputMaps) {
    List<String> ids = inputMaps.stream()
        .map(m -> m.get("id")).collect(Collectors.toList());
    return Stream.of("foo", "bar", "baz")
        .collect(Collectors.toMap(Function.identity(), s -> ids));
}