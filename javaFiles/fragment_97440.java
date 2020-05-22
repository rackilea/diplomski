public static int process(int [][] data) {
    final AtomicInteger c = new AtomicInteger();
    Thread[] threads = new Thread[data.length];
    for (int i = 0; i < data.length; i++) {
        final int [] row = data[i];
        threads[i] = new Thread() {
            public void run() {
                for (int s0 = 0, s1 = 1; s0 < row.length - 1; s0++, s1 = s0 + 1) {
                    if (row[s0] > row[s1]) {
                        row[s0] ^= row[s1]; row[s1] ^= row[s0]; row[s0] ^= row[s1];
                        c.incrementAndGet();
                    }
                }
            }
        };
        threads[i].start();
    }
    try {
        for (Thread thread : threads)
            thread.join();
    } catch (InterruptedException e) {}
    return c.intValue();
}