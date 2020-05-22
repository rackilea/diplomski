private static void renameElement(Document document, Element element) {
    document.renameNode(element, null, element.getNodeName().replace(':', '-'));
    NodeList children = element.getChildNodes();
    for(int i = 0; i < children.getLength(); i++) {
        Node child = children.item(i);
        if (child instanceof Element) {
            renameElement(document, (Element) child);
        }

    }
}