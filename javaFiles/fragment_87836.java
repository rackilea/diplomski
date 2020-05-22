public static void paintAllNodes(Node node) {
    if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element somethingElement = node.getOwnerDocument().createElement("something");
        somethingElement.setAttribute("style", "background-color:red");
        node.getParentNode().replaceChild(somethingElement, node);
        somethingElement.appendChild(node);
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            paintAllNodes(nodeList.item(i));
        }
    }
}