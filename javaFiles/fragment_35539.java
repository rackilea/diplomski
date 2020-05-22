private static final Pattern dotPattern = Pattern.compile("\\.");

public static void main(final String... args) {
    final Map<String, Object> map = ImmutableMap.of("stackoverflow.questions.value", "value");
    final Splitter<Map.Entry<String, Object>, Map<String, Object>, String, Object> toMapSplitter = MapSplitters.of(dotPattern::split);
    final Splitter<Map.Entry<String, Object>, JsonObject, String, Object> toJsonObjectSplitter = JsonElementSplitters.of(dotPattern::split);
    // A simple to-inner-maps split example
    System.out.println(Split.split(map.entrySet(), toMapSplitter));
    // A simple to-nested-JSON-objects split example
    System.out.println(Split.split(map.entrySet(), toJsonObjectSplitter));
    // Or even use it with Java 8 Stream API
    System.out.println(
            map.entrySet()
                    .stream()
                    .map(e -> new AbstractMap.SimpleImmutableEntry<>(e.getKey().toUpperCase(), e.getValue()))
                    .collect(Split.asCollector(toMapSplitter))
    );
}