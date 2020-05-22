@EnableAsync
@Configuration
public class AsyncConfig {
    @Bean(name = "threadPoolExecutor")
    public Executor getAsyncExecutor() {
      ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
      executor.setCorePoolSize(7);
      executor.setMaxPoolSize(42);
      executor.setQueueCapacity(11);
      executor.setThreadNamePrefix("threadPoolExecutor-");
      executor.initialize();
      return executor;
    }
}