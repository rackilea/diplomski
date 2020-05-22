links ="<root>"+links+"</root>";
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
factory.setNamespaceAware(false);
DocumentBuilder builder = factory.newDocumentBuilder();
Document doc=builder.parse(links ByteArrayInputStream(xml.getBytes()));
NodeList nl = ((Element)doc.getDocumentElement()).getChildNodes();
for (int temp = 0; temp < nl .getLength(); temp++) { 
Node nNode = nl .item(temp);
    //Here you create your new Element based on the Node nNode, and the add it to the new DOM you're building

}