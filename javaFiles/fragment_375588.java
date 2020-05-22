public static <K,V> Function<K,V> cache(Function<K,V> f, Map<K,V> cache)
{
    return k -> cache.computeIfAbsent(k, f);
}

public static <K,V> Function<K,V> cache(Function<K,V> f)
{
    return cache(f, new IdentityHashMap<>());
}