CacheManager cacheManager = initCacheManager();
CacheConfigurationBuilder<Long, String> configuration = 
    CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder
      .heap(100))
      .withExpiry(Expirations.timeToLiveExpiration(new Duration(20, TimeUnit.SECONDS)));
cacheManager.createCache("myCache", configuration);