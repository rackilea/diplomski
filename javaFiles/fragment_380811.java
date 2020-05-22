@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport {

    @Bean
    @Override
    public CacheManager cacheManager() {
        return  new EhCacheCacheManager(new net.sf.ehcache.CacheManager());
    }
}