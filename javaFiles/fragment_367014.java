AtomicReference<Thread> first = new AtomicReference<>();

        Dog bubu = new Dog("Bubu",2);
        Thread th1 = new Thread(() -> {
            bubu.run();
            first.compareAndSet(null, Thread.currentThread());
        }, "Bubu");

        Rabbit lepri = new Rabbit("Lepri",3);
        Thread th2 = new Thread(() -> {
            lepri.run();
            first.compareAndSet(null, Thread.currentThread());
        }, "Lepri");

        th1.start();
        th2.start();
        th1.join();
        th2.join();

        System.err.println("First: "+first);