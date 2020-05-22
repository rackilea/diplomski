@Component
public class OutboundMessagesChannelInterceptor implements ChannelInterceptor {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        // modify your message as needed
        return message;
    }

}