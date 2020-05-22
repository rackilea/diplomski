public static void main(String[] args) {
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    CountDownClock clock1 = new CountDownClock("A");

    Future<?> f1 = scheduler.scheduleWithFixedDelay(clock1, 3, 10, TimeUnit.SECONDS);

    Runnable cancelTask = new Runnable() {
        public void run() {
            f1.cancel(true);
        }
    };

    scheduler.schedule(cancelTask, 120, TimeUnit.SECONDS);
}