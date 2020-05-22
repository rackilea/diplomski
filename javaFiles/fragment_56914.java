@Bean
public AsyncTaskExecutor getAsync(){
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(7);
    executor.setMaxPoolSize(42);
    executor.setQueueCapacity(11);
    executor.setThreadNamePrefix("AsyncExec-");
    executor.initialize();
    return executor;
}