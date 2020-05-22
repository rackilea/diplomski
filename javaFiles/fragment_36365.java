private static final AtomicLong TS = new AtomicLong();
public static long getUniqueTimestamp() {
    long micros = System.currentTimeMillis() * 1000;
    for ( ; ; ) {
        long value = TS.get();
        if (micros <= value)
            micros = value + 1;
        if (TS.compareAndSet(value, micros))
            return micros;
    }
}