public class LogVisitorsListener implements ServletContextListener {

    private ScheduledExecutorService scheduler;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        scheduler = Executors.newSingleThreadScheduledExecutor();

        // It will be executed every 1 hour
        scheduler.scheduleAtFixedRate(new DailyHitsRunnable(), 0, 1, TimeUnit.HOURS); 
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        scheduler.shutdownNow();
    }
}