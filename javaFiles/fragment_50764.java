import java.util.HashMap;
import java.util.Map;

import javax.cache.CacheManager;
import javax.cache.Caching;

import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.ResourcePools;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.EntryUnit;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.core.config.DefaultConfiguration;
import org.ehcache.jsr107.EhcacheCachingProvider;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {


    @Bean
    public JCacheCacheManager jCacheCacheManager() {
        JCacheCacheManager jCacheManager = new JCacheCacheManager(cacheManager());
        return jCacheManager;
    }

    @Bean(destroyMethod = "close")
    public CacheManager cacheManager() {

        ResourcePools resourcePools = ResourcePoolsBuilder.newResourcePoolsBuilder()
                .heap(2000, EntryUnit.ENTRIES)
                .offheap(100, MemoryUnit.MB)
                .build();


        CacheConfiguration<Object,Object> cacheConfiguration = CacheConfigurationBuilder.newCacheConfigurationBuilder(
                Object.class,
                Object.class,
                resourcePools).
                build();

        Map<String, CacheConfiguration<?, ?>> caches = new HashMap<>();
        caches.put("myCache", cacheConfiguration);

        EhcacheCachingProvider provider = (EhcacheCachingProvider) Caching.getCachingProvider("org.ehcache.jsr107.EhcacheCachingProvider");
        org.ehcache.config.Configuration configuration = new DefaultConfiguration(caches, provider.getDefaultClassLoader());

        return  provider.getCacheManager(provider.getDefaultURI(), (org.ehcache.config.Configuration) configuration);
    }

}