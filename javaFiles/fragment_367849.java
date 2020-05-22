public class RangeSetHashMap<K, V extends Comparable> extends AbstractMap<K, RangeSet<V>> {
    private final Map<K, RangeSet<V>> map = new HashMap<>();

    public RangeSet<V> put(K key, Range<V> value) {
        RangeSet<V> rangeSet = computeIfAbsent(key, k -> TreeRangeSet.create());
        rangeSet.add(value);
        return rangeSet;
    }

    @Override
    public RangeSet<V> put(K key, RangeSet<V> value) {
        return map.put(key, value);
    }

    @Override
    public Set<Entry<K, RangeSet<V>>> entrySet() {
        return map.entrySet();
    }
}