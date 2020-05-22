public class MyLogicalHandler implements LogicalHandler<LogicalMessageContext> {
    private final String RejectionResponseBody = "<ns2:MessageControllerResponse xmlns:ns2=\"http://some.namespace.com/\"><return>SOMEDATA</return></ns2:MessageControllerResponse>";

    @Override
    public boolean handleMessage(LogicalMessageContext context) {       
        return true;
    }

    @Override
    public boolean handleFault(LogicalMessageContext context) {
        processMessage(context);
        return true;
    }

    @Override
    public void close(MessageContext context) {

    }

    private void processMessage(LogicalMessageContext context) {
        Boolean outboundProperty = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (outboundProperty) {
            LogicalMessage msg = context.getMessage();
            msg.setPayload(new StreamSource(new ByteArrayInputStream(RejectionResponseBody.getBytes())));
        }
    }   
}