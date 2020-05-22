@Bean
public ThreadPoolTaskScheduler taskExecutor() {
    ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
    scheduler.setPoolSize(20);
    return scheduler;
}