public static <K,V> Map.Entry<K,V> entry(K k, V v) {
    return new AbstractMap.SimpleImmutableEntry<>(k, v);
}
public static <K,V> Map<K,V> ofEntries(Map.Entry<? extends K,? extends V>... entries) {
    return Arrays.stream(entries)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
}