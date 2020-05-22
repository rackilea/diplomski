@Bean
public Jackson2JsonMessageConverter jackson2Converter() {
    Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
    return converter;
}

@Bean
public RabbitListenerContainerFactory rabbitListenerContainerFactory() {
    SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory = new SimpleRabbitListenerContainerFactory();
    simpleRabbitListenerContainerFactory.setConnectionFactory(connectionFactory());
    simpleRabbitListenerContainerFactory.setMessageConverter(jackson2Converter());
    return simpleRabbitListenerContainerFactory;
}