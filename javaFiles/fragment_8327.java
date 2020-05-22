public StreamEx<T> distinct(long atLeast) {
    if (atLeast <= 1)
        return distinct();
    AtomicLong nullCount = new AtomicLong();
    ConcurrentHashMap<T, Long> map = new ConcurrentHashMap<>();
    return filter(t -> {
        if (t == null) {
            return nullCount.incrementAndGet() == atLeast;
        }
        return map.merge(t, 1L, (u, v) -> (u + v)) == atLeast;
    });
}