class MapValueComparator<K, V extends Comparable<V>>
implements Comparator<Map<K, V>> {
    final K key;

    MapValueComparator(K key) {
        this.key = key;
    }

    @Override
    public int compare(Map<K, V> map1, Map<K, V> map2) {
        return map1.get(key).compareTo(map2.get(key));
    }
}