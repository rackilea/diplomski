@ConfigurationProperties("kafka")
public class KafkaAppProperties {

    private Map<String, String> topics  = new HashMap<>();

    public Map<String, String> getTopics() {
        return this.topics;
    }

}