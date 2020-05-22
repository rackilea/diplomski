public final class NonReplacementMap<K, V> implements Map<K, V> {
    private final Map<K, V> original;

    public NonReplacementMap(Map<K, V> original) {
        this.original = original;
    }

    @Override
    public void put(K key, V value) {
        if (original.containsKey(key)) {
            // Or whatever unchecked exception you want
            throw new IllegalStateException("Key already in map");
        }
        original.put(key, value);
    }

    // etc
}