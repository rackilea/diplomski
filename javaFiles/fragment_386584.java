topicCount.put(msgTopic, new Integer(partitionCount));
Map<String, List<KafkaStream<byte[], byte[]>>> consumerStreams = connector.createMessageStreams(topicCount);
List<KafkaStream<byte[], byte[]>> streams = consumerStreams.get(msgTopic);

for (final KafkaStream stream : streams) {
    ReadTask task = new ReadTask(stream, msgTopic);
    task.addObserver(this.msgObserver);
    tasks.add(task); executor.submit(task);
}