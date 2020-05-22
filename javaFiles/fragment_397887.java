public boolean handleMessage(SOAPMessageContext context) {

    AttributedURI messageIdURI = (AttributedURI)context.get("com.ibm.wsspi.wsaddressing.inbound.MessageID");
    String messageId = "";
    if (messageIdURI != null && messageIdURI.getURI() != null) {
        messageId = messageIdURI.getURI().toString();
    }
    EndpointReference fromApplicationEPR = (EndpointReference)context.get("com.ibm.wsspi.wsaddressing.inbound.FromEPR");
    String fromApplication = "";
    if (fromApplicationEPR != null && fromApplicationEPR.getAddress() != null &&
        fromApplicationEPR.getAddress().getURI() != null) {
        fromApplication = fromApplicationEPR.getAddress().getURI().toString();
    }

    ...

    return true;
}