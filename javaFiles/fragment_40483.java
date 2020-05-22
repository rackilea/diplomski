Properties props = ...//here you put your properties
AdminClient kafkaClient = AdminClient.create(props);

//Here you get all the consumer groups
List<String> groupIds = kafkaClient.listConsumerGroups().all().get().
                       stream().map(s -> s.groupId()).collect(Collectors.toList()); 

//Here you get all the descriptions for the groups
Map<String, ConsumerGroupDescription> groups = kafkaClient.
                                               describeConsumerGroups(groupIds).all().get();
for (final String groupId : groupIds) {
    ConsumerGroupDescription descr = groups.get(groupId);
    //find if any description is connected to the topic with topicName
    Optional<TopicPartition> tp = descr.members().stream().
                                  map(s -> s.assignment().topicPartitions()).
                                  flatMap(coll -> coll.stream()).
                                  filter(s -> s.topic().equals(topicName)).findAny();
            if (tp.isPresent()) {
                //you found the consumer, so collect the group id somewhere
            }
}