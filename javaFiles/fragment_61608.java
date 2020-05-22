public class IndexedMap<V> extends HashMap<Long, V> {
    private AtomicLong index = new AtomicLong();

    public void put(V value) {
        put(index.getAndIncrement(), value);
    }
}