private String treeToPost(Node node) {
    String returnString = "";
    if (node != null) {
        returnString += treeToPost(node.left);
        returnString += treeToPost(node.right);
        returnString += node.data.getName();
    }
    return returnString;
}