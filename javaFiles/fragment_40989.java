public class ServerHandler implements SOAPHandler<SOAPMessageContext> {
    @Override
    public boolean handleMessage(final SOAPMessageContext context) {
        final Boolean outbound = (Boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if ((outbound != null) && !outbound) {
            //...
        }
        return true;
    }
}