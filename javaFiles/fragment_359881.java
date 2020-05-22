public int getLevel(TreeNode node) {
    if(node == null)
        return 0;

    int l = getLevel(node.left);
    int r = getLevel(node.right);
    if ( (l < 0 ^ r < 0) || Math.abs(l - r) > 1) {
        // you can simply return -1 here, since an actual
        // level should never have a negative value
        return -1;
    }
    else {
        return Math.max(l + 1, r + 1);
    }
}