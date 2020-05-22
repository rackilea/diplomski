private static Node currentMax;

private Node maxElement(Node node) {
    if (currentMax == null || node == null)
        return currentMax;
    else if (node.getKey() > currentMax.getKey())
        currentMax = node;
    return maxElement(node.getNext());
}