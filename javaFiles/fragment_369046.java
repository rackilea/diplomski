public static void main(String[] args) throws Exception {
    String xml = "<Root>text 1<!-- test -->text 2</Root>";
    DocumentBuilder domBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    Document doc = domBuilder.parse(new InputSource(new StringReader(xml)));
    printDom("", doc);
    deleteComments(doc);
    printDom("", doc);
    doc.normalizeDocument();
    printDom("", doc);
}
private static void deleteComments(Node node) {
    if (node.getNodeType() == Node.COMMENT_NODE)
        node.getParentNode().removeChild(node);
    else {
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++)
            deleteComments(children.item(i));
    }
}