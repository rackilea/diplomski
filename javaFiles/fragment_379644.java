public void inorder(TreeNode root, Integer result, List<Integer> resultSet){
    if (root.left == null && root.right == null){
        resultSet.add(result);
    }
    if (root.left != null) {
        inorder(root.left, result+Integer.valueOf(root.left.val), resultSet);
    }
    if (root.right != null) {
        inorder(root.right, result+Integer.valueOf(root.right.val), resultSet);
    }
}