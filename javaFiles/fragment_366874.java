@Bean
public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
                                                DefaultJmsListenerContainerFactoryConfigurer configurer) {
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    factory.setPubSubDomain(true);
    factory.setSubscriptionDurable(true);
    factory.setClientId("jmsDemo");
    // This provides all boot's default to this factory, including the message converter
    configurer.configure(factory, connectionFactory);
    // You could still override some of Boot's default if necessary.
    return factory;
}