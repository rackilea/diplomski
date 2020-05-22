@Bean
public Binding bindingQueueProcessingElavonSale() {
    return BindingBuilder.bind(new Queue(QUEUE_PROCESSING_ELAVON_SALE, true))
            .to(new TopicExchange(EXCHANGE_PROCESSING)).with(ROUTING_KEY_PROCESSING_TRANSACTION_ELAVON);
}

@Bean
public Binding bindingQueueProcessingElavonAuthorize() {
    return BindingBuilder.bind(new Queue(QUEUE_PROCESSING_ELAVON_AUTHORIZE, true))
            .to(new TopicExchange(EXCHANGE_PROCESSING)).with(ROUTING_KEY_PROCESSING_TRANSACTION_ELAVON);
}