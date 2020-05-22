@Component
public class ScheduledUpdatesOnTopic{

    @Autowired
    private SimpMessagingTemplate template;
    @Autowired
    private final MessagesSupplier messagesSupplier;

    @Scheduled(fixedDelay=300)
    public void publishUpdates(){
        template.convertAndSend("/topic/greetings", messagesSupplier.get());
    }
}