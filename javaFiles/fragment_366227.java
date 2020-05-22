@SpringBootApplication
//@EnableScheduling
@EnableAutoConfiguration
@EnableCaching
public class Application {
    @Bean
    public CacheManager cacheManager() {
        // configure and return an implementation of Spring's CacheManager SPI
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("default")));
        return cacheManager;
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}