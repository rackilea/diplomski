@Bean
public CacheManager cacheManager() throws URISyntaxException {
    CachingProvider provider = Caching.getCachingProvider();  
    CacheManager cacheManager = provider.getCacheManager();   

    CacheConfigurationBuilder<SimpleKey, Double> configuration = 
    CacheConfigurationBuilder.newCacheConfigurationBuilder(org.springframework.cache.interceptor.SimpleKey.class,
        java.lang.Double.class, 
        ResourcePoolsBuilder.heap(2).offheap(10, MemoryUnit.MB))
        .withExpiry(Expirations.timeToLiveExpiration(new Duration(15, TimeUnit.SECONDS)));

    Cache cache = cacheManager.createCache("pow_cache", configuration);
    cache.getRuntimeConfiguration().registerCacheEventListener(listener, EventOrdering.UNORDERED,
        EventFiring.ASYNCHRONOUS, EnumSet.of(EventType.CREATED, EventType.EXPIRED)); 
    return cacheManager;
}