try {
    ScheduledExecutorService threadSchedulerService = Executors.newScheduledThreadPool(1);

    SampleThreadClass sampleThreadClass = new SampleThreadClass();
    threadSchedulerService.scheduleAtFixedRate(sampleThreadClass , 0, 5, TimeUnit.MINUTES);

    Thread.sleep(8000);