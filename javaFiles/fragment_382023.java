public String getNodeIndex(JTree tree, TreeNode node) {
    TreeNode root = (TreeNode) tree.getModel().getRoot();
    if (node == root) {
        return "";
    }
    TreeNode parent = node.getParent();
    if (parent == null) {
        return null;
    }
    String parentIndex= getNodeIndex(tree, parent);
    if (parentIndex == null) {
        return null;
    }
    return parentIndex+"."+parent.getIndex(node);
}