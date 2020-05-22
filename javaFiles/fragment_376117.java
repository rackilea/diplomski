public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
    BufferInputStream payload = (BufferInputStream) message.getPayload();
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(payload);

    String typeData = doc.getDocumentElement().getElementsByTagName("type:Data").item(0).getTextContent();