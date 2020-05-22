public static class WriteOnceMap<K, V> extends HashMap<K, V> {
    public V put(K key, V value) {
        if (containsKey(key))
            throw new IllegalArgumentException(key + " already in map");

        return super.put(key, value);
    }


    public void putAll(Map<? extends K, ? extends V> m) {
        for (K key : m.keySet())
            if (containsKey(key))
                throw new IllegalArgumentException(key + " already in map");

        super.putAll(m);
    }
}