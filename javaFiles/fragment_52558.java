private boolean treeCompare(Node firstNode, Node secondNode) {
    if (firstNode == secondNode)
        return true;

    if (firstNode == null || !firstNode.equals(secondNode))
        return false;

    return treeCompare(firstNode.left, secondNode.left) && treeCompare(firstNode.right, secondNode.right);
}