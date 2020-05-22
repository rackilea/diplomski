private int sigma(Node subtreeRoot) {
    int tot = 0;
    if (subtreeRoot == null) {
        return 0;
    }
    if (findParent(subtreeRoot) == null) {
        tot = sigma(subtreeRoot.left) + sigma(subtreeRoot.right);
    } else{
        tot = (Integer) subtreeRoot.data - (Integer) findParent(subtreeRoot).data
                + sigma(subtreeRoot.left) + sigma(subtreeRoot.right);
    }
    return tot;
}