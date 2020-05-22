private static String getXPath(Node test_tempNode) {
    if (test_tempNode == null
            || test_tempNode.getNodeType() != Node.ELEMENT_NODE) {
        return "";
    }

    //find index of the test_tempNode node in parent "list"
    Node parent = test_tempNode.getParentNode();
    NodeList childNodes = parent.getChildNodes();
    int index = 0;
    int found = 0;
    for (int i = 0; i < childNodes.getLength(); i++) {
        Node current = childNodes.item(i);
        if (current.getNodeName().equals(test_tempNode.getNodeName())) {
            if (current == test_tempNode) {
                found = index;
            }
            index++;
        }
    }

    String strIdx = "[" + found + "]";
    if(index == 1){
        strIdx = "";
    }
    return getXPath(test_tempNode.getParentNode()) + "/"
            + test_tempNode.getNodeName() + strIdx;
}