public class PopulateSOAPMessagePayloadHandler implements SOAPHandler<SOAPMessageContext> {
    public static final String SOAP_MESSAGE_PAYLOAD = "__soap_message_payload";

    @Override
    public boolean handleMessage(SOAPMessageContext smc) {
        Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (!outboundProperty.booleanValue()) {
            // for incoming:
            ByteArrayOutputStream bout = new ByteArrayOutputStream(1024);
            try {
                smc.getMessage().writeTo(bout);
                String payload = bout.toString(StandardCharsets.UTF_8.name());

                smc.put(SOAP_MESSAGE_PAYLOAD, payload);  //Set payload
                smc.setScope(SOAP_MESSAGE_PAYLOAD, MessageContext.Scope.APPLICATION);  //make it application scope

            } catch (SOAPException | IOException e) {
                e.printStackTrace();
                // handle exception if needed
                throw new WebServiceException(e);
            }

        }
        return true;
    }
 // Other method (no-op) omitted 
}