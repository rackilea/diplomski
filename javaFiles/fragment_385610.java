@Override
public boolean handleMessage(final SOAPMessageContext messageContext) {
    if (messageContext == null) {
        LOG.warning("The messageContext was nilled. Unable to handle the soapMessage.");
        return false;
    }
    if (Boolean.FALSE.equals(messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY))) {
        LOG.finest("Some cool incoming message");
    } else {
        LOG.finest("Some cool outgoing message");
    }
    return true;
}