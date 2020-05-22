int parallelCallables = 6;
    ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("Grabber-thread-%d").build();
    ExecutorService facebookInfoGrabberExecutor = Executors.newFixedThreadPool(parallelCallables, namedThreadFactory);
    List<Future<Boolean>> futures = facebookInfoGrabberExecutor.invokeAll(tasks);
    // Add this!!!
    facebookInfoGrabberExecutor.shutdown();
    while (!facebookInfoGrabberExecutor.awaitTermination(1, TimeUnit.MINUTES)) {
        System.out.println("Waiting");
    }
    System.out.println("All done.");