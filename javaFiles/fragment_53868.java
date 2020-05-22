public void startElement(String uri, String qName, String lName, Attributes atts) {
    previousNode = currentNode;
    // Use the result of the getNodeText method to construct the tree node.
    currentNode = new DefaultMutableTreeNode(getNodeText(lName, atts));
    // Add attributes as child nodes //
    attachAttributeList(currentNode, atts);
    previousNode.add(currentNode);
}

private String getNodeText(final String lName, final Attributes atts) {
    final String postfix;

    if ("NE".equals(lName) && atts.getValue("NEType") != null)
        postfix = " NEType=" + atts.getValue("NEType");
    else if ("EQHO".equals(lName) && atts.getValue("equipmentHolderType") != null)
        postfix = " equipmentHolderType=" + atts.getValue("equipmentHolderType");
    else
        postfix = "";

    return lName + postfix;
}