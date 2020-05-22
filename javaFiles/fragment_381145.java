public class ConsumerEventsHandler implements Runnable {

private static Consumer consumer;
private List<String> topics;
protected final KafkaConsumer<String, String> kafkaConsumer;

public ConsumerEventsHandler(List<String> topics) {
    this.topics = topics;
    this.kafkaConsumer = new KafkaConsumer<>();
}

public static setConsumer(Consumer consumer) {
    ConsumerEventsHandler.consumer = consumer;
}