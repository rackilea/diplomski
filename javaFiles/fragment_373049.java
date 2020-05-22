public class StripHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        boolean isResponse = Boolean.FALSE.equals(context.get (MessageContext.MESSAGE_OUTBOUND_PROPERTY));
        if (isResponse) {
            QName action = (QName) context.get(SOAPMessageContext.WSDL_OPERATION);
            if ("Create".equals(action.getLocalPart())) {
                Iterator<?> childIter = getBodyChildren(context);
                while(childIter.hasNext()) {
                    SOAPElement el = (SOAPElement) childIter.next();
                    if ("Shell".equals(el.getLocalName())) {
                        childIter.remove();
                    }
                }
            }
        }
        return true;
    }

    private Iterator<?> getBodyChildren(SOAPMessageContext context) {
        try {
            SOAPEnvelope envelope = context.getMessage().getSOAPPart().getEnvelope();
            SOAPBody body = envelope.getBody();
            return body.getChildElements();
        } catch (SOAPException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {return true;}
    @Override
    public void close(MessageContext context) {}
    @Override
    public Set<QName> getHeaders() {return null;}

}