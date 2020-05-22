public static void createPartitions(String topicName, int numPartitions) {
    Properties props = new Properties();
    props.put("bootstrap.servers","localhost:9092");
    AdminClient adminClient = AdminClient.create(props);

    Map<String, NewPartitions> newPartitionSet = new HashMap<>();
    newPartitionSet.put(topicName, NewPartitions.increaseTo(numPartitions));
    adminClient.createPartitions(newPartitionSet);
    adminClient.close();
}