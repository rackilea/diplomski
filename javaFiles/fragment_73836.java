int countNrOfInnerNodes(Node node) {
    if (node == null)
        return 0;

    Stack<Node> nodesToCheck = new Stack<Node>();

    nodesToCheck.push(node);
    int count = 0;

    while (!nodesToCheck.isEmpty()) {
        Node checkedNode = nodesToCheck.pop();
        boolean isInnerNode = false;

        if (node.left != null) {
            isInnerNode = true;
            nodesToCheck.push(node.left);
        }

        if (node.right != null) {
            isInnerNode = true;
            nodesToCheck.push(node.right);
        }

        if (isInnerNode)
            count++;
    }

    return count;
}