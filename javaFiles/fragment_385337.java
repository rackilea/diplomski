public class ExtendedTcpOutpboundGateway extends TcpOutboundGateway {

    private final MessageChannel unsolicitedMessageChannel;


    public ExtendedTcpOutpboundGateway(MessageChannel unsolicitedMessageChannel) {
        this.unsolicitedMessageChannel = unsolicitedMessageChannel;
    }

    @Override
    public boolean onMessage(Message<?> message) {
        if (isUnsolicitedMessage(message)) {
            this.messagingTemplate.send(this.unsolicitedMessageChannel, message);
            return false;
        }
        else {
            return super.onMessage(message);
        }
    }

    private boolean isUnsolicitedMessage(Message<?> message) {
        // TODO Add logic here to determine message type
        return false;
    }

}