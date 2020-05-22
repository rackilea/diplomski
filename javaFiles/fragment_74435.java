public final boolean handleMessage(SOAPMessageContext context) {
    // Using `Object` type as we don't have any need to import servlet libraries into a JAX-WS library
    Object o = context.get(MessageContext.SERVLET_REQUEST);
    // o will hold a reference to the request 
    // if inbound.o == outbound.o the request objects are identical and therefor we can associate them.
    return true;
}