public static <K, V> Map<K, V> toMap(Object... entries) {
    if(entries.length % 2 == 1)
        throw new IllegalArgumentException("Invalid entries");
    return (Map<K, V>)IntStream.range(0, entries.length/2).map(i -> i*2)
        .collect(HashMap::new, (m,i)->m.put(entries[i], entries[i+1]), Map::putAll);
}