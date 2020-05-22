final AtomicInteger g = new AtomicInteger()

    ExecutorService threadPool = Executors.newFixedThreadPool(10);
    for (int i = 0; i < 10; i++) {
        threadPool.submit(new Runnable() {
            public void run() {
                int local = g.incrementAndGet();
                myFunc(local);
            }
        });
    }