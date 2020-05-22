@Autowired
private ConnectionFactory connectionFactory;

@Autowired
private SomeService someService;

@RabbitListener(id = "queueListener", queues = "queueName",
        containerFactory = "listenerContainerFactory")
@RabbitHandler
public void notifyLegacyListener(SomeObject obj) {
    someService.doSomething(obj);
}

@Bean
public SimpleRabbitListenerContainerFactory listenerContainerFactory() {
    SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
    factory.setConnectionFactory(connectionFactory);
    factory.setMessageConverter(jsonMessageConverter());
    factory.setConcurrentConsumers(3);
    factory.setMaxConcurrentConsumers(10);
    factory.setAdviceChain(new Advice[] {retries()});
    return factory;
}

@Bean
public RetryOperationsInterceptor retries() {
    return RetryInterceptorBuilder.stateless().maxAttempts(Queues.QUEUE_LEGACY.getMaxAttempts())
            .backOffOptions(1000,
                    3.0, 10000)
            .recoverer(new RejectAndDontRequeueRecoverer()).build();
}

@Bean
public MessageConverter jsonMessageConverter() {
    return new Jackson2JsonMessageConverter();
}