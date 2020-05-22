private static <K, V> V mappedValue(TreeMap<K, V> map, K key) {
    Entry<K, V> e = map.floorEntry(key);
    if (e != null && e.getValue() == null) {
        e = map.lowerEntry(key);
    }
    return e == null ? null : e.getValue();
}