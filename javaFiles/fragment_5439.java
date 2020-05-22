private ScheduledExecutorService scheduler; 

@PreDestroy
public void destroy() {
    scheduler.shutdownNow();
}