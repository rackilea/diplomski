public Set<TreeNode<T>> getAllLeafNodes() {
    Set<TreeNode<T>> leafNodes = new HashSet<TreeNode<T>>();
    if (this.children.isEmpty()) {
        leafNodes.add(this);
    } else {
        for (TreeNode<T> child : this.children) {
            leafNodes.addAll(child.getAllLeafNodes());
        }
    }
    return leafNodes;
}