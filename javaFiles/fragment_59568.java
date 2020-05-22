@Service
public class SomeSubscribeListener {

    private SimpMessagingTemplate template;

    @Autowired
    public SomeSubscribeListener(SimpMessagingTemplate template) {
        this.template = template;
    }

    @EventListener
    public void handleSubscribeEvent(SessionSubscribeEvent event) {
        template.convertAndSendToUser(event.getUser().getName(), "/queue/notify", "GREETINGS");
    }
}