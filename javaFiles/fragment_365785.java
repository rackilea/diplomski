public class MyTreeMap<K, V> extends TreeMap<K, V> {
    @Override
    public V put(K key, V val) {
        V ret = super.put(key, val);
        myAddCallback(key, val);
        return ret;
    }

    @Override
    public V remove(K key) {
        V ret = super.remove(key);
        myRemoveCallback(key);
        return ret;
    }
}