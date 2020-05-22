ThreadFactory tf = runnable -> {
        return new Thread(() -> {
            try {
                runnable.run();
            } finally {
                System.out.println(Thread.currentThread().getName()+": my thread exit");
            }
        });
    };

    ExecutorService svc = Executors.newFixedThreadPool(3, tf);
    Future f = svc.submit(() -> System.out.println(Thread.currentThread().getName()+": some task"));
    f.get();
    svc.shutdown();

    Thread.sleep(2000);
    System.out.println("main done");