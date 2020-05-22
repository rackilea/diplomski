public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, TransformerException {
    String xml = "<ns2:Attribute Name=\"Store\" NameFormat=\"urn:oasis:names:tc:SAML:2.0:attrname-format:uri\"><ns2:AttributeValue/></ns2:Attribute>";
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(new ByteArrayInputStream(xml.getBytes()));
    doc.getDocumentElement().normalize();
    NodeList nList = doc.getElementsByTagName("ns2:AttributeValue");
    for (int i=0;i<nList.getLength();i++) {
        Element elem = (Element)nList.item(i);
        elem.setTextContent("Content"+i);
    }
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();
    DOMSource source = new DOMSource(doc);
    StreamResult result = new StreamResult(System.out);

    transformer.transform(source, result);



System.out.println(nList.getLength());
}