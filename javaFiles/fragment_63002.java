public class IdUtil {
    private static final AtomicLong counter = new AtomicLong(System.currentTimeMillis());

    // return a single id
    public static long getId() {
        return counter.getAndIncrement();
    }

    // return a block of ids
    public static Queue<Long> getIds(long span) {
        long max = counter.addAndGet(span);
        Queue<Long> queue = new ArrayDeque<>(span);
        for(int i = max - span; i < max; i++) {
            queue.add(i);
        }
    }
}