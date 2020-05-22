public void recurseNodes(Node node) {
    NodeList nodeList = node.getChildNodes();
    for(int i = 0; i < nodeList.getLength(); i++){
        Node childNode = nodeList.item(i);
        // do something with the node .. then recurse into childnode
        recurseNodes(childNode);
    }
}