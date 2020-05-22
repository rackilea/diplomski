private static void test() throws SOAPException {

        MessageFactory factory = MessageFactory
                .newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
        SOAPMessage message = factory.createMessage();
        SOAPPart soapPart = message.getSOAPPart();

        SOAPEnvelope envelope = soapPart.getEnvelope();

        SOAPBody soapBody = envelope.getBody();

        QName stockQname = new QName("http://your_namespace_uri.com",
                "getStock", "prefix");
        SOAPBodyElement stockElement = soapBody.addBodyElement(stockQname);

        QName accessQname = new QName("accessToken");
        SOAPElement accessElement = stockElement.addChildElement(accessQname);
        accessElement.addTextNode("xxx");

        QName companyQname = new QName("company");
        SOAPElement companyElement = stockElement.addChildElement(companyQname);
        companyElement.addTextNode("AS");

        QName itemQname = new QName("itemNumber");
        SOAPElement itemElement = stockElement.addChildElement(itemQname);
        itemElement.addTextNode("020001");

        QName commisionQname = new QName("commissionNumber");
        SOAPElement commissionElement = stockElement
                .addChildElement(commisionQname);
        commissionElement.addTextNode("0");

        message.saveChanges();
}