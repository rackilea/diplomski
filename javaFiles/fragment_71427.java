public class MyHashMap<K,V> extends HashMap<K,V> {
    public V get(K key, V default) {
        V ret = get(key);
        if (ret == null) {
            return defaultValue;
        }
        return ret;
    }
}