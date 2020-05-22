private final Lock lock = new ReentrantLock();
private List<T> items = new ArrayList<T>();

public void add(T item) {
    lock.lock();
    // trivial lock time.
    try {
        // Add item while holding the lock.
        items.add(item);
    } finally {
        lock.unlock();
    }
}

public List<T> makeSnapshot() {
    List<T> copy = new ArrayList<T>(), ret;
    lock.lock();
    // trivial lock time.
    try {
        ret = items;
        items = copy;
    } finally {
        lock.unlock();
    }
    return ret;
}

public static void main(String... args) {
    long start = System.nanoTime();
    Main<Integer> ints = new Main<>();
    for (int j = 0; j < 100 * 1000; j++) {
        for (int i = 0; i < 1000; i++)
            ints.add(i);
        ints.makeSnapshot();
    }
    long time = System.nanoTime() - start;
    System.out.printf("The average time to add was %,d ns%n", time / 100 / 1000 / 1000);
}