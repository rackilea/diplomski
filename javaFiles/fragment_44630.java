Counter c = new SynchronizedCounter();
    (new Thread(() -> {
        c.increment();
    })).start();

    (new Thread(() -> {
        if (c.value() != 1) {
            synchronizedErrors.incrementAndGet();
        }
    })).start();