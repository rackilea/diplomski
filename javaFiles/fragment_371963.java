@Configuration
@EnableScheduling
public class SpringConfiguration {

    @Bean(destroyMethod = "shutdown")
    public Executor taskScheduler() {
        return Executors.newScheduledThreadPool(5);
    }
    ...