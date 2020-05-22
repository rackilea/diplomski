public boolean handleMessage(SOAPMessageContext smc) {

    Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

    if (outboundProperty.booleanValue()) {

        SOAPMessage message = smc.getMessage();

        try {
            SOAPFactory soapFactory = SOAPFactory.newInstance();
            SOAPEnvelope envelope = smc.getMessage().getSOAPPart().getEnvelope();
            SOAPHeader header = envelope.addHeader();
            SOAPHeaderElement se=header.addHeaderElement(new QName("http://schemas.microsoft.com/ws/2005/05/addressing/none", "Action"));
            //se.setMustUnderstand(true); //Ideal way to set if webservice supports
            se.addTextNode("some text");
            se.addAttribute(soapFactory.createName("S:mustUnderstand"),"1"); //S: or s: depending on xmlns

        } catch (Exception e) {
            e.printStackTrace();
        }

    } else {
        try {
            SOAPMessage message = smc.getMessage();
            message.writeTo(System.out);
            System.out.println("");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    return true;
}