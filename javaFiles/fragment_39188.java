LoadingCache<Long, Object> byUserIdMutex = CacheBuilder.newBuilder()
        .concurrencyLevel(4)
        .weakKeys()
        .maximumSize(10000)
        .expireAfterWrite(10, TimeUnit.MINUTES)
        .build(CacheLoader.from(Object::new));

private Object getMutex(long userId) {
    return byUserIdMutex.getUnchecked(userId);
}