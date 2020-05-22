MessageFactory messageFactory = MessageFactory.newInstance();

public SOAPMessage toMessage(Document jdomDocument) throws IOException, SOAPException {
   String xml = new XMLOutputter().outputString(jdomDocument);
   InputStream inputStream = new StringBufferInputStream(xml);
   return messageFactory.createMessage(null, inputStream);
}