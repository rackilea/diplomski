public class GetOnceHashMap<K,V> extends HashMap<K,V> {
    @Override
    public V get(Object key) {
        return remove(key);
    }

    @Override
    public Collection<V> values() {
        Collection<V> v = new ArrayList<V>(super.values());
        clear();
        return v;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> e = new HashSet<Map.Entry<K,V>>(super.entrySet());
        clear();
        return e;
    }
}