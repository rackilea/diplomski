public static void removeNode(Node node) {
    if (node != null) {
        while (node.hasChildNodes()) {
            removeNode(node.getFirstChild());
        }

        Node parent = node.getParentNode();
        if (parent != null) {
            parent.removeChild(node);
            NodeList childNodes = parent.getChildNodes();
            if (childNodes.getLength() > 0) {
                List<Node> lstTextNodes = new ArrayList<Node>(childNodes.getLength());
                for (int index = 0; index < childNodes.getLength(); index++) {
                    Node childNode = childNodes.item(index);
                    if (childNode.getNodeType() == Node.TEXT_NODE) {
                        lstTextNodes.add(childNode);
                    }
                }
                for (Node txtNodes : lstTextNodes) {
                    removeNode(txtNodes);
                }
            }
        }
    }
}