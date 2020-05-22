@Bean(name="taskExecutor")
public ThreadPoolTaskExecutor taskExecutor() 
{
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(3);
    executor.setMaxPoolSize(5);
    return executor;
}