public static class ConcurrentSetMap<K, V> {
    private final ConcurrentMap<K, Set<V>> map = new ConcurrentHashMap<K, Set<V>>();

    public synchronized void add(K key, V value) {
        Set<V> set = map.get(key);
        if (set != null) {
            set.add(value);
        } else {
            map.put(key, createConcurrentSet(value));
        }
    }

    public synchronized void remove(K key, V value) {
        Set<V> set = map.get(key);
        if (set != null) {
            set.remove(value);
            if (set.isEmpty()) {
                map.remove(key);
            }
        }
    }

    public boolean contains(K key, V value) {
        return get(key).contains(value);
    }

    public Set<V> get(K key) {
        Set<V> set = map.get(key);
        return set == null ? Collections.<V> emptySet() : set;
    }

    protected Set<V> createConcurrentSet(V value) {
        Set<V> set = Collections.newSetFromMap(new ConcurrentHashMap<V, Boolean>());
        set.add(value);
        return set;
    }
}