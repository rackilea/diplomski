private int maxElem(Node node) {
    int max = node.element;
    if(node.left != null) {
        max = Math.max(max, maxElem(node.left));
    }
    if(node.right != null) {
        max = Math.max(max, maxElem(node.right));
    }
    return max;
}