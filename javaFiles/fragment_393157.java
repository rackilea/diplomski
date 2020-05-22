@SpringBootApplication
@EnableAsync
public class Application {

public static void main(String[] args) {
    SpringApplication.run(Application.class, args).close();
}

@Bean
public Executor asyncExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(2);
    executor.setMaxPoolSize(2);
    executor.setQueueCapacity(500);
    executor.setThreadNamePrefix("ThreadName-");
    executor.initialize();
    return executor;
}
}