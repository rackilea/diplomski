private static SOAPMessage createSOAPRequest(FileInputStream requestFile, String serverURI, String serviceName) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        MimeHeaders headers = new MimeHeaders();

        SOAPMessage soapMessage = messageFactory.createMessage(headers, requestFile);
        requestFile.close();

        String authorization = new sun.misc.BASE64Encoder().encode((username+":"+password).getBytes());
        headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI  + serviceName);
        headers.addHeader("Authorization", "Basic " + authorization);
        soapMessage.saveChanges();

        return soapMessage;
    }