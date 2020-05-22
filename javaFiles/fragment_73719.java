@Bean
public ReactiveRedisTemplate<String, String> reactiveRedisTemplateString
(ReactiveRedisConnectionFactory connectionFactory) {
    return new ReactiveRedisTemplate<>
              (connectionFactory, RedisSerializationContext.string());
}