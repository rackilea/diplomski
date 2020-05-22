@Autowired
private KafkaAppProperties properties;

@Bean
public Map<String, String> kafkaTopic() {
    return this.properties.getTopics();
}

...

@KafkaListener(topics = "#{@kafkaTopic.values()}")
public void handle(Object record) {
    ...
}