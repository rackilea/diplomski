@Bean
public SimpleMessageListenerContainerFactory simpleMessageListenerContainerFactory() {
    SimpleMessageListenerContainerFactory factory = new SimpleMessageListenerContainerFactory();        
    factory.setAmazonSqs(customAmazonClient);

    return factory;
}

@Bean
public QueueMessageHandlerFactory queueMessageHandlerFactory() {
    QueueMessageHandlerFactory factory = new QueueMessageHandlerFactory();
    factory.setAmazonSqs(customAmazonClient);

    return factory;
}