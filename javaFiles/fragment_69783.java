@Bean
public ConcurrentKafkaListenerContainerFactory<String, GenericRecord>
kafkaListenerContainerFactory()  {

    ConcurrentKafkaListenerContainerFactory<String, GenericRecord> factory
            = new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());
    factory.getContainerProperties().setErrorHandler(new ErrorHandler() {
        @Override
        public void handle(Exception thrownException, List<ConsumerRecord<?, ?>> records, Consumer<?, ?> consumer, MessageListenerContainer container) {
            String s = thrownException.getMessage().split("Error deserializing key/value for partition ")[1].split(". If needed, please seek past the record to continue consumption.")[0];
            String topics = s.split("-")[0];
            int offset = Integer.valueOf(s.split("offset ")[1]);
            int partition = Integer.valueOf(s.split("-")[1].split(" at")[0]);

            TopicPartition topicPartition = new TopicPartition(topics, partition);
            //log.info("Skipping " + topic + "-" + partition + " offset " + offset);
            consumer.seek(topicPartition, offset + 1);
            System.out.println("OKKKKK");
        }

        @Override
        public void handle(Exception e, ConsumerRecord<?, ?> consumerRecord) {

        }

        @Override
        public void handle(Exception e, ConsumerRecord<?, ?> consumerRecord, Consumer<?,?> consumer) {
            String s = e.getMessage().split("Error deserializing key/value for partition ")[1].split(". If needed, please seek past the record to continue consumption.")[0];
            String topics = s.split("-")[0];
            int offset = Integer.valueOf(s.split("offset ")[1]);
            int partition = Integer.valueOf(s.split("-")[1].split(" at")[0]);

            TopicPartition topicPartition = new TopicPartition(topics, partition);
            //log.info("Skipping " + topic + "-" + partition + " offset " + offset);
            consumer.seek(topicPartition, offset + 1);
            System.out.println("OKKKKK");


        }
    });


    return factory;
}