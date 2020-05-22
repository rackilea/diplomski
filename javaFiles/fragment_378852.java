final Thread incThread = new Thread(() -> {
        count.increment();
    });

    final Thread decThread = new Thread(() -> {
        count.decrement();
    });

    Thread displayThread = new Thread(() -> {
        incThread.join();
        decThread.join();
        System.out.println("Count value : " + count.getX());
    });