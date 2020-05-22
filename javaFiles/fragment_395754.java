@Configuration
@EnableCaching
public class CacheConfiguration extends CachingConfigurerSupport {
    @Slf4j
    private static class RelaxedCacheErrorHandler extends SimpleCacheErrorHandler {
        @Override
        public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
            log.error("Error getting from cache.", exception);
        }
    }

    @Override
    public CacheErrorHandler errorHandler() {
        return new RelaxedCacheErrorHandler();
    }

    // More config...
}