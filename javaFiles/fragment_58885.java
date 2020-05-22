package mypackage.io;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

public class CustomPartitioner implements Partitioner {

public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {

    String receivingkey = (String) key;
    long id = Long.parseLong(receivingkey);
    int numPartitions = cluster.availablePartitionsForTopic(topic).size();
    return (int) (id % numPartitions);
}

public void close() {

}

public void configure(Map<String, ?> map) {

}
}