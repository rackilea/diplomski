public function isSingleChild(Node node) {
    boolean singleChild = true;
    NodeList siblings = node.getParentNode().getChildNodes();
    for(int i = 0, int len = siblings.getLength(); i < len; i++) {
        if(siblings.item(i).getNodeType() == Node.ELEMENT_NODE) {
            singleChild = false;
            break;
        }
    }

    return singleChild;
}