@Bean
public  RedisConnectionFactory connectionFactory(){

    RedisClusterConfiguration clusterConf = 
        new RedisClusterConfiguration(
            redisClusterProperties.getNodes());

    clusterConf.setPassword(RedisPassword.of("yourPassword"));

    return new JedisConnectionFactory(clusterConf);
}