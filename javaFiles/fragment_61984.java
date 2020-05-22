ExecutorService pool = Executors.newFixedThreadPool(3);
    Set<Future<String[][]>> set = new HashSet<Future<String[][]>>();
    CountDownLatch startSignal = new CountDownLatch(1);
    CountDownLatch doneSignal = new CountDownLatch(3);
    for (int i=1;i<=3;i++) {
        Worker worker = new Worker(startSignal,doneSignal,i);
        Callable<String[][]> callable =
                worker.getSomeCallableStrArrArr();
        Future<String[][]> future = pool.submit(callable);
        set.add(future);
    }