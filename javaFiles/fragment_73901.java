public static List getChildren(Element element) {
    List<Element> elements = new ArrayList<>();
    NodeList nodeList = element.getChildNodes();
    for (int i = 0; i < nodeList.getLength(); i++) {
        Node node = nodeList.item(i);
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            elements.add((Element) node);
        }
    }
    return elements;
}