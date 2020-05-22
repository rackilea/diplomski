@Configuration
class RedisConfiguration  {

    @Value("${spring.redis.host}")
    private String redisHostname;
    @Value("${spring.redis.port}")
    private int redisPort;

    @Bean(destroyMethod = "close")
    public StatefulRedisConnection<String, String> redisClient() {
        RedisURI redisURI = RedisURI.create(redisHostname,redisPort);
        return RedisClient.create(redisURI);
        redisConnection = redisClient.connect();
    }

    @Bean(destroyMethod = "close")
    public StatefulRedisConnection<String, String> redisConnection(RedisClient client) {
        return client.connect();
    }

    @Bean
    public RedisCommands redisCommands(StatefulRedisConnection<String, String> connection) {
        return connection.sync();
    }
}