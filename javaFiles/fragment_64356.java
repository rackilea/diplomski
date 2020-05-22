public class IndexedCache<K,V> implements Cache<K,V> {

    @Delegate
    private Cache<K, V> cache;
    private Map<Class<?>, Map<Object, Set<K>>> indexes;

    private IndexedCache(Builder<K, V> bldr){
        this.indexes = bldr.indexes;
        cache = bldr.caf.build();
    }

    public <R> void invalidateAllWithIndex(Class<R> clazz, R value) {
        cache.invalidateAll(indexes.get(clazz).getOrDefault(value, new HashSet<>()));
    }

    public static class Builder<K, V>{
        Map<Class<?>, Function<K, ?>> functions = new HashMap<>();
        Map<Class<?>, Map<Object, Set<K>>> indexes = new ConcurrentHashMap<>();
        Caffeine<K,V> caf;

        public <R> Builder<K,V> withIndex(Class<R> clazz, Function<K, R> function){
            functions.put(clazz, function);
            indexes.put(clazz, new ConcurrentHashMap<>());
            return this;
        }

        public IndexedCache<K, V> buildFromCaffeine(Caffeine<Object, Object> caffeine) {
            caf = caffeine.writer(new CacheWriter<K, V>() {

                @Override
                public void write( K k, V v) {
                    for(Map.Entry<Class<?>, Map<Object, Set<K>>> indexesEntry : indexes.entrySet()){
                        indexesEntry.getValue().computeIfAbsent(functions.get(indexesEntry.getKey()).apply(k), (ky)-> new HashSet<>())
                        .add(k);
                    }
                }

                @Override
                public void delete( K k,  V v,  RemovalCause removalCause) {
                    for(Map.Entry<Class<?>, Map<Object, Set<K>>> indexesEntry : indexes.entrySet()){
                        indexesEntry.getValue().remove(functions.get(indexesEntry.getKey()).apply(k));
                    }
                }
            });
            return new IndexedCache<>(this);
        }
    }

}