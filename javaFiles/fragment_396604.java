try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(configs);) {
    Map<TopicPartition, Long> timestamps = new HashMap<>();
    timestamps.put(new TopicPartition("mytopic", 0), System.currentTimeMillis()-1*1000);
    Map<TopicPartition, OffsetAndTimestamp> offsets = consumer.offsetsForTimes(timestamps);
    System.err.println(offsets);
}