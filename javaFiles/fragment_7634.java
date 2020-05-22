static <K,V> Map<K,V> map(K k1, V v1, K k2, V v2, K k3, V v3) {
    LinkedHashMap<K,V> m=new LinkedHashMap<>();
    m.put(k1, v1);
    m.put(k2, v2);
    m.put(k3, v3);
    return m;
}