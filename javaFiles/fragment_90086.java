@Bean
public ThreadPoolTaskExecutor taskExecutor() {
    final ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
    taskExecutor.setThreadFactory(threadFactory());
    return taskExecutor;
}

@Bean
public ThreadFactory threadFactory() {
    return new CustomizableThreadFactory("Custom-prefix-");
}