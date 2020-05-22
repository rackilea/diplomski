@Component
public class ClearCacheTask {
    @Autowired
    private CacheManager cacheManager;

    @Scheduled(fixedRateString = "${clear.all.cache.fixed.rate}", initialDelayString = "${clear.all.cache.init.delay}") // reset cache every hr, with delay of 1hr after app start
    public void reportCurrentTime() {
        cacheManager.getCacheNames().parallelStream().forEach(name -> cacheManager.getCache(name).clear());
    }
}