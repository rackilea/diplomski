public class HashedList<K, V> {
    private final List<V> list = new ArrayList<>();
    private final Map<K, V> map = new HashMap<>(); 

    protected K getKey(V val);

    public void add(V value) {
        list.add(value);
        map.put(getKey(value), value);
    }

    public V get(int index) {
        return list.get(index);
    }

    public V get(K key) {
        return map.get(key);
    }
}