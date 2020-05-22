private static final AtomicLong TIME_ID = new AtomicLong(0);
private static long generateTimeId() {
    long now = System.currentTimeMillis() * 1000000;
    long id = TIME_ID.getAndIncrement();
    if (id > now)
        return id;
    TIME_ID.compareAndSet(id+1, now);
    return TIME_ID.getAndIncrement();
}

// produce a monotonically increasing time id.
private final long timeCreate = generateTimeId();
private final int hashCode = (int)((timeCreate >> 32) ^ timeCreate);