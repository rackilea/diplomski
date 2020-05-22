class HeterogeneousCache {

    private final LoadingCache<Key<?>, Object> cache;

    public <T> T get(Key<T> key) throws ExecutionException {
        return key.getType().cast(cache.get(key));
    }
}

@Value // provides constructor, getters, equals, hashCode
class Key<T> {

    private final String identifier;
    private final Class<T> type;
}