private final AtomicInteger counter = new AtomicInteger(0);

public void increment() {
    int count;
    do {
        count = counter.get();
        if (count == Integer.MAX_VALUE) {
            return;
        }
    } while (!counter.compareAndSet(count, count+1));
}