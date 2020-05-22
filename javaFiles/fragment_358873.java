@Bean
public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(
        SimpleRabbitListenerContainerFactoryConfigurer configurer,
        ConnectionFactory connectionFactory) {
    SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
    configurer.configure(factory, connectionFactory);
    factory.setConsumerTagStrategy(q -> "myConsumerFor." + q);
    return factory;
}

@RabbitListener(queues = "foo")
public void listen(String in) {
    System.out.println(in);
}