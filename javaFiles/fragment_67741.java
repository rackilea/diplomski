public TreeNode successor(TreeNode node) {
    if (node == null)
        return node;

    if (node.right != null) {
        return leftMostNode(node.right);
    }

    while (null != node.parent /*while we are not root*/ 
            && node.parent.right == node) /* and while we are "right" node */ {

        node = node.parent; // go one level up
    }

    return node.parent;
}