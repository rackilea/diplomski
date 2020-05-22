@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport {
@Bean
public SecuritiesInfoManager myService() {
    // configure and return a class having @Cacheable methods
    return new SecuritiesInfoManager();
 }
//rest same as before
}