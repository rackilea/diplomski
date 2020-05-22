interface KeyValueService<K,V> {
    V get(K key);
}

class CachingKeyValueService<K,V> {
    Cache<K,Optional<V>> cache;
    V get(K key) {
        return cache.get(key).orNull();
    }

}