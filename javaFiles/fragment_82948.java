public class MyEntry<K, V> implements Entry<K, V> {
    private final K key;
    private V value;
    public MyEntry(final K key) {
        this.key = key;
    }
    public MyEntry(final K key, final V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }
    public V setValue(final V value) {
        final V oldValue = this.value;
        this.value = value;
        return oldValue;
    }
}