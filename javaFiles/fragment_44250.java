public static String createSOAPFaultServerError(final Exception cause) {
    String result = null;
    LOG.error("Creating SOAP fault, hiding original cause from client:", cause);
    try {
        SOAPMessage message = MessageFactory.newInstance().createMessage();
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        SOAPBody body = message.getSOAPBody();
        SOAPFault fault = body.addFault();
        fault.setFaultCode("Server");
        fault.setFaultString("Unexpected server error.");
        Detail detail = fault.addDetail();
        Name entryName = envelope.createName("message");
        DetailEntry entry = detail.addDetailEntry(entryName);
        entry.addTextNode("The server is not able to complete the request. Internal error.");

        result = soapMessage2String(message);
    } catch (Exception e) {
        LOG.error("Error creating SOAP Fault message", e);
    }

    return result;
}

private static String soapMessage2String(final SOAPMessage message) throws SOAPException, IOException {
    String result = null;

    ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    message.writeTo(outStream);
    result = new String(outStream.toByteArray(), StandardCharsets.UTF_8);

    return result;
}