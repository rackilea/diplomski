public String innerXml(Node node) {
    DOMImplementationLS lsImpl = (DOMImplementationLS)node.getOwnerDocument().getImplementation().getFeature("LS", "3.0");
    LSSerializer lsSerializer = lsImpl.createLSSerializer();
    NodeList childNodes = node.getChildNodes();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < childNodes.getLength(); i++) {
       sb.append(lsSerializer.writeToString(childNodes.item(i)));
    }
    return sb.toString(); 
}