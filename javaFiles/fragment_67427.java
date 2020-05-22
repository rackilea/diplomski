@Configuration
@EnableCaching
@PropertySource(value = { "classpath:/cache.properties" })
public class CacheConfig {

    @Bean
    @Primary
    public CacheManager hazelcastCacheManager() {
        ClientConfig config = new ClientConfig();
        HazelcastInstance client = HazelcastClient.newHazelcastClient(config);
        return new HazelcastCacheManager(client);
    }

    @Bean
    public CacheManager guavaCacheManager() {
         GuavaCacheManager cacheManager = new GuavaCacheManager("mycache");
           CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.newBuilder()
           .maximumSize(100)
           .expireAfterWrite(10, TimeUnit.MINUTES);
           cacheManager.setCacheBuilder(cacheBuilder);
           return cacheManager;
    }

}