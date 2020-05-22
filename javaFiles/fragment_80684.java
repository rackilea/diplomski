import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import kafka.admin.AdminClient;
import kafka.coordinator.GroupOverview;

Properties props = new Properties();
props.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, "kafka-1:9092");
AdminClient adminClient = AdminClient.create(props);

List<GroupOverview> groups =  scala.collection.JavaConversions.seqAsJavaList(
        adminClient.listAllConsumerGroupsFlattened());
for (GroupOverview group : groups) {
    String groupId = group.groupId();

    Properties consProps = new Properties();
    consProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka-1:9092");
    consProps.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
    consProps.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
    consProps.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
    consProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
    consProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
    KafkaConsumer consumer = new KafkaConsumer(consProps);

    List<AdminClient.ConsumerSummary> groupSummaries = scala.collection.JavaConversions.seqAsJavaList(
            adminClient.describeConsumerGroup(groupId));

    System.out.println("GROUP, TOPIC, PARTITION, CURRENT OFFSET, LOG END OFFSET, LAG, OWNER");

    for (AdminClient.ConsumerSummary summary : groupSummaries) {
        String owner = summary.clientId() + "_" + summary.clientHost();
        List<TopicPartition> topicPartitions = scala.collection.JavaConversions.seqAsJavaList(
                summary.assignment());
        for (TopicPartition tp : topicPartitions) {

            // Get current offset
            long currentOffset = consumer.committed(tp).offset();

            // get log end offset
            consumer.assign(Arrays.asList(tp));
            consumer.seekToEnd();
            long logEndOffset = consumer.position(tp);

            long lag = logEndOffset - currentOffset;

            System.out.println(groupId + ", " + tp.topic() + ", " + tp.partition() + ", " +
                    currentOffset + ", " + logEndOffset + ", " + lag + ", " + owner);
        }
    }
}