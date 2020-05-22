public void changeTagName(Document doc, String tag, String fromTag, String toTag) {
    NodeList nodes = doc.getElementsByTagName(fromTag);
    for (int i = 0; i < nodes.getLength(); i++) {
        if (nodes.item(i) instanceof Element) {
            Element elem = (Element)nodes.item(i);
            doc.renameNode(elem, elem.getNamespaceURI(), toTag);
        }
    }
}