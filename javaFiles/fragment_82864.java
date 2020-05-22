public static void main(String[] args) throws Exception {

    DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    String input = "<A><B><C><C1><C11>something</C11><C12>something</C12></C1></C><D><D1><D11><D111 operation=\"create\"><Node>something else</Node></D111></D11></D1><D2><D21></D21></D2></D></B></A>";

    Document document = builder.parse(new InputSource(new StringReader(
            input)));

    removeNodes(document);

    Transformer transformer = TransformerFactory.newInstance()
            .newTransformer();
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    StreamResult result = new StreamResult(new StringWriter());
    transformer.transform(new DOMSource(document), result);
    System.out.println(result.getWriter().toString());
}

public static void removeNodes(Node node) {
    NodeList list = node.getChildNodes();
    for (int i = 0; i < list.getLength(); i++) {
        removeNodes(list.item(i));
    }
    boolean emptyElement = node.getNodeType() == Node.ELEMENT_NODE
            && node.getChildNodes().getLength() == 0;
    boolean emptyText = node.getNodeType() == Node.TEXT_NODE
            && node.getNodeValue().trim().isEmpty();
    if (emptyElement || emptyText) {
        node.getParentNode().removeChild(node);
    }
}