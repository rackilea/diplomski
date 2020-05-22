private String getId(Map<String, String> map) {
    return map.get("id");
}

public Map<String, List<String>> weirdMapFunction(List<Map<String, String>> inputMaps) {
    List<String> ids = inputMaps.stream()
        .map(this::getId).collect(Collectors.toList());
    return Stream.of("foo", "bar", "baz")
        .collect(Collectors.toMap(Function.identity(), s -> ids));
}