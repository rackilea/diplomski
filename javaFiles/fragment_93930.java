@Bean
  public ConnectionFactory connectionFactory() {
    com.rabbitmq.client.ConnectionFactory connectionFactory = new com.rabbitmq.client.ConnectionFactory();
    connectionFactory.setConnectionTimeout(this.connectionTimeout);
    connectionFactory.setHost(this.rabbitHost);
    connectionFactory.setPort(this.rabbitPort);
    CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(
        connectionFactory);
    return cachingConnectionFactory;
  }