@Component
public class MessageReceiver {
    private final List<MessageHandler> handlers;

    @Autowired
    public MessageReceiver(List<MessageHandler> handlers) {
        this.handlers = handlers;
    }

    public void receiveMessage(Message m) {
        for (MessageHandler handler : handlers) {
            handler.process(m);
        }
    }

}