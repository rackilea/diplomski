public HBTNode<T> findMaxCountNode(HBTNode<T> node) {
    return findMaxCountNode(node, node);
}

public HBTNode<T> findMaxCountNode(HBTNode<T> node, HBTNode<T> maxNode) {

    HBTNode<T> currMax = (node.getNumberOfHits() > maxNode.getNumberOfHits()) ? node : maxNode;

    if (node.getLeft() != null ) {
       currMax = findMaxCountNode(node.getLeft(), currMax);
    }

    if (node.getRight() != null) {
        currMax = findMaxCountNode(node.getRight(), currMax);
    }

    return currMax;
}

public int findMaxCount(HBTNode<T> node) {
    HBTNode<T> maxNode = findMaxCountNode(node);
    if (maxNode != NULL)
        return maxNode.getNumberOfHits();
    else
        return -1;
}