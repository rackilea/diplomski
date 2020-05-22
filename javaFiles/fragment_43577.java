public int twoChild(TreeNode<Integer> root) {

    // base case: tree is empty
    if (root == null) return 0;

    // base case: tree has both children, or not    
    int count = root.left != null && root.right != null ? 1 : 0;

    // recursive cases: traverse both subtrees, accumulating result
    count += twoChild(root.left);
    count += twoChild(root.right);

    // return result of recurring on both subtrees
    return count;

}