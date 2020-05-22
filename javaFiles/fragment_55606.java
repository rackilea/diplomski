public abstract class Listener {
  public CountDownLatch countDownLatch0 = new CountDownLatch(3);
  public CountDownLatch countDownLatch1 = new CountDownLatch(3);
  public CountDownLatch countDownLatch2 = new CountDownLatch(3);


  abstract void handlePartition0(record);
  abstract void handlePartition1(record);
  abstract void handlePartition2(record);

  @KafkaListener(id = "id0", topicPartitions = { @TopicPartition(topic = "SpringKafkaTopic1", partitions = { "0" }) })
  public void listenPartition0(ConsumerRecord<?, ?> record) {
    handlePartition0(record);
    countDownLatch0.countDown();
  }

  @KafkaListener(id = "id1", topicPartitions = { @TopicPartition(topic = "SpringKafkaTopic1", partitions = { "1" }) })
  public void listenPartition1(ConsumerRecord<?, ?> record) {
    handlePartition1(record);
    countDownLatch1.countDown();
  }

  @KafkaListener(id = "id2", topicPartitions = { @TopicPartition(topic = "SpringKafkaTopic1", partitions = { "2" }) })
  public void listenPartition2(ConsumerRecord<?, ?> record) {
    handlePartition2(record);
    countDownLatch2.countDown();
  }
}