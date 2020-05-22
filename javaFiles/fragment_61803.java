try {
    ScheduledExecutorService threadSchedulerService = Executors.newScheduledThreadPool(1);
    threadSchedulerService.scheduleAtFixedRate(new SampleThreadClass(), 0, 5, TimeUnit.MINUTES);
                                           //  ^ 1st Instance
    Thread.sleep(8000);

    SampleThreadClass sampleThreadClass = new SampleThreadClass(); // <-- 2nd Instance