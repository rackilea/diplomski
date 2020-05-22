@Override
public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
    super.doWithMessage(message);

    Assert.isInstanceOf(SaajSoapMessage.class, message);

    try {
        SOAPMessage soapMessage = ((SaajSoapMessage) message).getSaajMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();
        SOAPEnvelope soapEnvelope = soapPart.getEnvelope();

        if (soapEnvelope.getHeader() == null) {
            soapEnvelope.addHeader();
        }

        SOAPHeaderElement securityElement = soapEnvelope.getHeader().addHeaderElement(WS_SECURITY_NAME);
        securityElement.appendChild(soapPart.importNode(assertion, true));

    } catch (SOAPException ex) {
        throw new IOException(ex);
    }

}