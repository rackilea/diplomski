public class MyCacheImplementation<K, V> extends LinkedHashMap<K, V> {
    private final List<CacheExpirationListener<V>> removalListeners = new ArrayList<>();

    public void addRemovalListener(CacheExpirationListener<V> listener) {
        removalListeners.add(listener)
    }

    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        if(size() > LRUConcurrentCache.this.cacheSize) {
            removalListeners.forEach(CacheExpirationListener::entryExpired);
            return true;
        }

        return false;
    }
}