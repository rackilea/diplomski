ScheduledExecutorService exec = new ScheduledThreadPoolExecutor(1);

exec.scheduleWithFixedDelay(() -> {
    if (getConnection()) {
        System.out.println("Got connection, do some work.....");
        System.exit(0);  // Or exec.shutdown();
    } else {
        System.out.println("No connection, re-trying in 5 seconds");
    }
}, 0, 5, TimeUnit.SECONDS);