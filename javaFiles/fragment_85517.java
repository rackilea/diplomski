public class MyMessageHandler implements SOAPHandler<SOAPMessageContext> {

@Override
public boolean handleMessage(SOAPMessageContext context) {
    Boolean outbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
    if (outbound.booleanValue()) {
        try {
            context.getMessage().setProperty(SOAPMessage.CHARACTER_SET_ENCODING,
                            "ISO-8859-1");
        }
        catch (SOAPException e) {
            throw new RuntimeException(e);
        }
    }
    return true;
}