Node getNodes(String tagName, NodeList nodes) {
    for(int i=0; i< nodes.getLength();i++) {
        Node node= nodes.item(i);
        if(node.getNodeName().equalsIgnoreCase(tagName)) {
            return node;
        }
    }
    return null;
}