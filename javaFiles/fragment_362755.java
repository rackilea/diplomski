private ScheduledExecutorService scheduler;

public void contextInitialized(ServletContextEvent event) {
    scheduler = Executors.newSingleThreadScheduledExecutor();
    scheduler.scheduleAtFixedRate(new CleanDBTask(), 0, 1, TimeUnit.HOURS);
    scheduler.scheduleAtFixedRate(new StatisticsTask(), 0, 15, TimeUnit.MINUTES);
}

public void contextDestroyed(ServletContextEvent event) {
    scheduler.shutdownNow();
}