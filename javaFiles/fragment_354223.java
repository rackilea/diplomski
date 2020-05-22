@Component
public class EventResultHandler {

    @RabbitListener(queues=Queues.QUEUE_NAME_PRESENTATION_SERVICE)
    public void handleMessage(@Payload Event event) {
        System.out.println("Event received");
        System.out.println("EventType: " + event.getType().getText());
    }
}