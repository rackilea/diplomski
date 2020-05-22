@Slf4j
@Component
public class MyMessageConsumer {

    @KafkaListener(topicPattern = "test_topic")
    public void receive(List<MyMessage> myMessages){
        log.info("Received payload {}", myMessages);
    }
}