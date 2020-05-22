@Bean
@InboundChannelAdapter(value = "fromKafkaChannel",
    poller = @Poller(fixedRate = "10", maxMessagesPerPoll = "1"))
public MessageSource<Map<String, Map<Integer, List<Object>>>> kafkaMessageSource() {
    return new KafkaHighLevelConsumerMessageSource<String, String>();
}

@Bean
public KafkaConsumerContext<String, String> kafkaConsumerContext() {
    KafkaConsumerContext<String, String> kafkaConsumerContext = new KafkaConsumerContext<String, String>();
    .....
    kafkaConsumerContext.setConsumerConfigurations(map);
    return kafkaConsumerContext;
}