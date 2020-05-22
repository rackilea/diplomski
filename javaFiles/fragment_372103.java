public class UniqueValueHashMap<K,V> extends HashMap<K, V>{
@Override
public V put(K key, V value) {
    if (containsKey(key))
        return null;
    return super.put(key, value);
}