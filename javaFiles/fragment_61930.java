@Bean
public RMQConnectionFactory connectionFactory(@Value("${spring.rabbitmq.host}") String host,
        @Value("${spring.rabbitmq.port}") int port) {
    RMQConnectionFactory cf = new RMQConnectionFactory();
    cf.setHost(host);
    cf.setPort(port);
    return cf;
}