final IntegerDeserializer keyDeserializer = new IntegerDeserializer();
final MyValueDeserializer myValueDeserializer = new MyValueDeserializer();
final KafkaConsumer<Integer, MyMessage> consumer = new KafkaConsumer<>(props, keyDeserializer, myValueDeserializer);

ConsumerRecords<Integer, MyMessage> records = consumer.poll(1000);
for (ConsumerRecord<Integer, MyMessage> record : records) {

    int kafkaKey = record.key();
    MyMessage kafkaValue = record.value();

    ...
}