public class MyMap<K, V> {

    private ConcurrentHashMap<K, V> map;

    public V put(K key, V value) {
        synchronize(map) {
            if(map.get(key) != null) {
                map.remove(key);
            } else {
                map.put(key, value);
        }
    }

    public V get(Object key) {
        synchronize(map) {
            return map.get(key);
        }
    }
}