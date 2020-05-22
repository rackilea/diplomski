private static <V, K> Map<V, K> invert(Map<K, V> map) {

    Map<V, K> inv = new HashMap<V, K>();

    for (Entry<K, V> entry : map.entrySet())
        inv.put(entry.getValue(), entry.getKey());

    return inv;
}