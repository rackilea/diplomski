public Node searchUpFor(String tagToFind, Node aNode) {
    Node n = aNode.getParentNode();
    while (n != null && !n.getNodeName().equals(tagToFind)) {
        n = n.getParentNode();
    }
    return n;
}