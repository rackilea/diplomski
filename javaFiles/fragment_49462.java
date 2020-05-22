private static void replace(Node root){
    if (root.getNodeType() == root.TEXT_NODE){
        root.setTextContent(root.getTextContent().replace("Home Owners Agreement", "HMO"));
    }
    for (int i = 0; i < root.getChildNodes().getLength(); i++){ 
        outputTextOfNode(root.getChildNodes().item(i));
    }
}