public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
        return false;
    } else {
        return hasPathSumHelper(root, sum);
    }

}

boolean hasPathSumHelper(TreeNode root, int sum) {
    if (root.left == null && root.right == null) {//if leaf node
        if (Integer.valueOf(root.val) == sum) { //if node value is equal to sum
            return true;
        } else {
            return false;
        }
    }
    if ((root.left != null) && (root.right != null)) {
        return (hasPathSumHelper(root.left, sum - Integer.valueOf(root.val)) || hasPathSumHelper(root.right, sum - Integer.valueOf(root.val)));
    }
    if (root.left != null) {
        return hasPathSumHelper(root.left, sum - Integer.valueOf(root.val));
    } else {
        return hasPathSumHelper(root.right, sum - Integer.valueOf(root.val));
    }
}