@Bean(name = "longLifeCacheManager")
public CacheManager longLifeCacheManager(JedisConnectionFactory jedisConnectionFactory) {
    RedisCacheConfiguration cacheConfiguration =
            RedisCacheConfiguration.defaultCacheConfig()
                    .entryTtl(Duration.ofSeconds(redisExpirationLong))
                    .disableCachingNullValues()
                    .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
    return RedisCacheManager.builder(jedisConnectionFactory).cacheDefaults(cacheConfiguration).build();
}