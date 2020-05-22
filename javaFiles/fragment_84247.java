interface EntryConsumer<K, V> {
    void apply(K key, V v1, V v2);
}

public static <K, V> void fancyStreams(Map<K, V> m1, Map<K, V> m2, EntryConsumer<K, V> consumer) {
    Stream
        .concat(m1.entrySet().stream(), m2.entrySet().stream())
        .filter(e -> e.getValue() != null) // filter out nulls
        .collect(Collectors.groupingBy(Map.Entry::getKey))
        .entrySet()
        .stream()
        .filter(e -> e.getValue().size() == 2) // filter out non-matching key-values
        .forEach(e -> consumer.apply(e.getKey(), e.getValue().get(0).getValue(), e.getValue().get(1).getValue()));
}

public static <K, V> void plainOldIteration(Map<K, V> m1, Map<K, V> m2, EntryConsumer<K, V> consumer) {
    m1.entrySet()
        .forEach(e -> {
            if (m2.containsKey(e.getKey())) 
                consumer.apply(e.getKey(), e.getValue(), m2.get(e.getKey()))
        });
}

// Actual usage
Map<String, Integer> m1, m2;
m1 = Maps.of("1", 22, "2", 23);
m2 = Maps.of("1", 20, "2", 19, "3", 21);
fancyStreams(m1, m2, (k, v1, v2) -> System.out.println(k + ": " + (v1 + v2)));
plainOldIteration(m1, m2, (k, v1, v2) -> System.out.println(k + ": " + (v1 + v2)));