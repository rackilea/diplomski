public static <K,V> Map<K,V> of() {
    return new HashMap<>();// or Collections.emptyMap() to create immutable maps
}
static <K,V> Map<K,V> of(K k1, V v1) {
    return ofEntries(entry(k1, v1));
}
static <K,V> Map<K,V> of(K k1, V v1, K k2, V v2) {
    return ofEntries(entry(k1, v1), entry(k2, v2));
}
static <K,V> Map<K,V> of(K k1, V v1, K k2, V v2, K k3, V v3) {
    return ofEntries(entry(k1, v1), entry(k2, v2), entry(k3, v3));
}
static <K,V> Map<K,V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
    return ofEntries(entry(k1, v1), entry(k2, v2), entry(k3, v3), entry(k4, v4));
}   
static <K,V> Map<K,V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
    return ofEntries(entry(k1, v1), entry(k2, v2), entry(k3, v3), entry(k4, v4));
}