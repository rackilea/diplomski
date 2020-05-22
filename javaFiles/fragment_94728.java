import java.util.Properties;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;

import kafka.admin.AdminUtils;
import kafka.utils.ZKStringSerializer$;
import kafka.utils.ZkUtils;

public class KafkaJavaExample {

    public static void main(String[] args) {
        String zookeeperConnect = "zkserver1:2181,zkserver2:2181";
        int sessionTimeoutMs = 10 * 1000;
        int connectionTimeoutMs = 8 * 1000;

        ZkClient zkClient = new ZkClient(
            zookeeperConnect,
            sessionTimeoutMs,
            connectionTimeoutMs,
            ZKStringSerializer$.MODULE$);

       // Security for Kafka was added in Kafka 0.9.0.0
       boolean isSecureKafkaCluster = false;
       // ZkUtils for Kafka was used in Kafka 0.9.0.0 for the AdminUtils API
       ZkUtils zkUtils = new ZkUtils(zkClient, new ZkConnection(zookeeperConnect), isSecureKafkaCluster);

       String topic = "my-topic";
       int partitions = 2;
       int replication = 3;

       // Add topic configuration here
       Properties topicConfig = new Properties();

       AdminUtils.createTopic(zkUtils, topic, partitions, replication, topicConfig);
       zkClient.close();
    }
}