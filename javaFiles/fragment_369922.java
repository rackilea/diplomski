import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;
import kafka.admin.AdminUtils;
import kafka.utils.ZKStringSerializer$;
import kafka.utils.ZkUtils;

public static void changeConfig(String topic) {
    ZkClient zkClient = new ZkClient("your_zkHost", 5000, 5000, ZKStringSerializer$.MODULE$);
    ZkUtils zkUtils = new ZkUtils(zkClient, new ZkConnection("your_zkHost"), false);
    Properties prop = new Properties();
    prop.setProperty("retention.ms", "3600000");
    AdminUtils.changeTopicConfig(zkUtils, topic, prop);
}