import javax.cache.configuration.Factory;
import javax.cache.expiry.ExpiryPolicy;

import org.apache.ignite.IgniteCache;
import org.apache.ignite.configuration.CacheConfiguration;

public class IgniteCacheManager {

    private IgniteCache<String, Object> igniteCache;

    public IgniteCacheManager(IgniteCache<String, Object> igniteCache) {
        this.igniteCache = igniteCache;
    }

    public long getTimeToLive() {
        CacheConfiguration configuration = igniteCache.getConfiguration(CacheConfiguration.class);
        Factory factory = configuration.getExpiryPolicyFactory();
        ExpiryPolicy policy = factory.create(); 
        long timeToLive = policy.getExpiryForCreation().getDurationAmount();
        return timeToLive;
    }
}