@Configuration
@EnableAsync
public class AsyncConfig {
   @Bean(name = "myTaskExecutor")
   public ThreadPoolTaskExecutor myTaskExecutor() {
      return new ThreadPoolTaskExecutor();
   }
}