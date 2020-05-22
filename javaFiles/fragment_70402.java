public interface MessageHandler extends Consumer<MessageBO> {
    public default void handle(MessageBO msg) { accept(msg); }
}

@Component
public class AMQListener {
    @Resource("multiplexer")
    MessageHandler handler;

    @JmsListener(destination = "${spring.activemq.topic}")
    public void Consume(TextMessage message) {
        try {
            String json = message.getText();
            MessageBO bo = ObjectMapperConfig.getInstance().readValue(json, MessageBO.class);
            handler.handle(bo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}