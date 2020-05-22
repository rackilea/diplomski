private TreeNode handleNode(TreeNode node, int val) {
    if(node == null)
        node = new TreeNode(val, this);
    else
        node.insert(val);
    return node;
}