public static MessageElement[] convertXMLStringtoMessageElement(String xmlString) throws SAXException, IOException, ParserConfigurationException{
        MessageElement[] m = new MessageElement[1];
        Document XMLDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(xmlString)));
        Element element = XMLDoc.getDocumentElement();
        m[0] = new MessageElement(element);
        return m;
    }