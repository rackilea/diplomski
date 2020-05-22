ArrayList<TreeNode> solve(TreeNode treeNode, int id) {
    if(treeNode == null) return null;
    if(treeNode.id == id) return treeNode.nodes;
    if(treeNode.nodes == null) return null;
    ArrayList<TreeNode> ans = null, temp = null;
    for(TreeNode t: treeNode.nodes) {
        temp = solve(t, id);
        if(temp != null) ans = temp;
    }
    return ans;
}