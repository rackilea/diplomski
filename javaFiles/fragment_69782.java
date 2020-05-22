@Bean
public ConsumerAwareListenerErrorHandler listen3ErrorHandler() {
return (m, e, c) -> {
    this.listen3Exception = e;
    MessageHeaders headers = m.getHeaders();
    c.seek(new org.apache.kafka.common.TopicPartition(
            headers.get(KafkaHeaders.RECEIVED_TOPIC, String.class),
            headers.get(KafkaHeaders.RECEIVED_PARTITION_ID, Integer.class)),
            headers.get(KafkaHeaders.OFFSET, Long.class));
    return null;
   };
}