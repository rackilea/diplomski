Node attr = attributes.getNamedItem("type");
if (attr != null) {
    if (attr.getTextContent().equals("translation")) {
        Element citElement = (Element) fieldNode;
        NodeList quoteNodeList = citElement.getElementsByTagName("quote");
        if(quoteNodeList.getLength() > 0) {
            Node quoteNode = quoteNodeList.item(0);
            String quote = quoteNode.getTextContent();
            ...
        }
    }
}