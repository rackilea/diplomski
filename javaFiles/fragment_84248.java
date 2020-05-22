public class EntryStream<K, V> {

    private final Map<K, V> m1;
    private final Map<K, V> m2;

    private EntryStream(Map<K, V> m1, Map<K, V> m2) {
        this.m1 = m1;
        this.m2 = m2;
    }

    public static <K, V> EntryStream<K, V> of(Map<K, V> m1, Map<K, V> m2) {
        return new EntryStream<>(m1, m2);
    }

    public void forEachCorrespondingEntry(EntryConsumer<K, V> consumer) {
        m1.entrySet()
            .forEach(e -> {
                if (m2.containsKey(e.getKey())) consumer.apply(e.getKey(), e.getValue(), m2.get(e.getKey()));
            });
    }
}

// Usage
EntryStream.of(m1, m2).forEachCorrespondingEntry((k, v1, v2) -> System.out.println(k + ": " + (v1 + v2)));