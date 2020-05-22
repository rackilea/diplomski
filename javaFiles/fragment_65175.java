private static SOAPMessage createSOAPRequest() throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        SOAPEnvelope envelope = soapPart.getEnvelope();      
        envelope.removeNamespaceDeclaration(envelope.getPrefix());
        envelope.addNamespaceDeclaration("SOAP-ENV","http://schemas.xmlsoap.org/soap/envelope/");
        envelope.setPrefix("SOAP-ENV");              

        envelope.addNamespaceDeclaration("paygo","http://paygo24.com/v3/protocol");
        envelope.addNamespaceDeclaration("tem","http://tempuri.org/");
        envelope.addNamespaceDeclaration("xsd","http://www.w3.org/2001/XMLSchema");
        envelope.addNamespaceDeclaration("xsi","http://www.w3.org/2001/XMLSchema-instance");

        SOAPHeader header=soapMessage.getSOAPHeader();                      
        header.setPrefix("SOAP-ENV");       
        SOAPBody soapBody = envelope.getBody();
        soapBody.setPrefix("SOAP-ENV");
        SOAPElement root=soapBody.addChildElement("SendRequest","tem");
        SOAPElement request=root.addChildElement("request","paygo");         
        request.setAttribute("xsi:type", "paygo:RegisterCheckRequest");
        request.setAttribute("Id","7a646d45-ee2f-4b1c-8de8-780c416fbbd0");
        request.setAttribute("Service","42");        
        SOAPElement paymentParameters =request.addChildElement("PaymentParameters");

        SOAPElement parameter=paymentParameters.addChildElement("Parameter");        
        paymentParameters.setAttribute("xmlns","");
        parameter.setAttribute("Name","account");
        parameter.setAttribute("Value", "08374829");
        root.addChildElement("pointId","tem").setValue("46");       
        root.addChildElement("password","tem").setValue("alkdsjflasdkjfl+ak87+UI90==");           
        soapMessage.getSOAPHeader().detachNode();
        soapMessage.saveChanges();

        soapMessage.writeTo(System.out);


        return soapMessage;
    }