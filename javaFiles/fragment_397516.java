private String treeToPost(Node node) {
    String returnString = "";
    if (node != null) {
        returnString += "(" + treeToPost(node.left);
        returnString += node.data.getName();
        returnString += treeToPost(node.right) + ")";
    }
    return returnString;
}