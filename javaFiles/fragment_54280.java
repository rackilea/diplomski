@Configuration
@EnableAsync
public class SpringAsyncConfig {

    @Bean(name = "threadPoolTaskExecutor")
     public Executor threadPoolTaskExecutor() {
     ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
     pool.setMaxPoolSize(10);
     return pool;
     }
 }