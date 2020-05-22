System.out.println("some stuff");

ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
final Runnable task = new Runnable() {

    @Override
    public void run() {
        System.out.println("do something");
    }
};
Future<?> futureHandle = scheduler.scheduleWithFixedDelay(task, 10, 10, TimeUnit.SECONDS);

System.out.println("some other stuff");