public class Producer {
    private final KafkaProducer<String, String> producer; // initialize in constructor

    public void publica(String topic, String strKey, String strValue) {
        ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topic, strValue);
        producer.send(rec);
    }
}