public class ProtectionistMap<K, V> extends ForwardingConcurrentMap<K, V> {

    private final ConcurrentMap<K, V> delegate;

    public ProtectionistMap(ConcurrentMap<K, V> delegate) {
        this.delegate = checkNotNull(delegate);
    }

    @Override
    protected ConcurrentMap<K, V> delegate() {
        return delegate;
    }

    @Override
    public V put(K key, V value) {
        V result = putIfAbsent(key, value);

        // The second part of the test is necessary when a map may contain null values...
        if (result != null || value == null && containsKey(key)) {
            throw new IllegalArgumentException("Map already had an entry for key " + key);
        }
        return result;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        standardPutAll(map);
    }
}