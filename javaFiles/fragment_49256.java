public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();

    if(root == null){
        return result;
    }

    result.add(root.val);
    if(root.left != null){
        result.addAll(preorderTraversal(root.left));
    }
    if(root.right != null){
        result.addAll(preorderTraversal(root.right));
    }

    return result;
}