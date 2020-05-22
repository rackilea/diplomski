public boolean isSubset(Document document, Element element) {
    NodeList list = document.getElementsByTagName(element.getNodeName());
    for (int i = 0; i < list.getLength(); i++) {
        Element el = (Element) list.item(i);
        Document clone = toNewDocument(el);
        //compare element with clone with XMLUnit
        //...
        if (equal) {
            return true;
        }
    }
    return false;
}

private Document toNewDocument(Element el) {
    // createing a new DOM-document...
    Document document = documentBuilder.newDocument();
    Node node = document.importNode(el, true);
    document.getDocumentElement().appendChild(node);
    return document;
}