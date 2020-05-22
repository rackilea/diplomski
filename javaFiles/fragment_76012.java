final Queue<Integer> numsPrinted = new ConcurrentLinkedQueue<>(); // a concurrent collection
    ScheduledFuture<?> future = scheduler.scheduleWithFixedDelay( // using scheduleWithFixedDelay because probably this is what you want
            new ScheduledPrinter(numsPrinted), // passing the reference
            10L, 10L, TimeUnit.SECONDS);
    try {
        future.isDone();
        Object obj = future.get(80, TimeUnit.SECONDS); // blocks until 80 secs or until the task is done
        System.out.println(obj);
        System.out.println(Arrays.toString(numsPrinted.toArray()));
    } catch (TimeoutException e) {
        System.out.println(Arrays.toString(numsPrinted.toArray()));
    } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
    }