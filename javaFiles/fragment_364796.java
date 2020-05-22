private TreeNode selectedTreeNode;

public void setSelectedTreeNode(TreeNode selectedTreeNode) {
    this.selectedTreeNode = selectedTreeNode;
    if (this.selectedTreeNode != null) {
        Object yourTreeNodeData = this.selectedTreeNode.getData();
        // do whatever you need to do with the data object...
    }
}