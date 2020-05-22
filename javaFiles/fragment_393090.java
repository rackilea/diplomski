@Bean(AMQP_INPUT_CHANNEL)
public MessageChannel amqpInputChannel() {
    return new DirectChannel();
}

@Bean
public AmqpInboundChannelAdapter inbound(SimpleMessageListenerContainer listenerContainer,  
                                         @Qualifier(AMQP_INPUT_CHANNEL) MessageChannel channel,
                                         Jackson2JsonMessageConverter messageConverter) {
    AmqpInboundChannelAdapter adapter = new AmqpInboundChannelAdapter(listenerContainer);   
    adapter.setMessageConverter(messageConverter);      
    adapter.setOutputChannel(channel);
    return adapter;
}

@Bean
public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory) {
    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);   
    container.setConcurrentConsumers(5);        
    container.setQueueNames("Queue_Name");          
    return container;
}