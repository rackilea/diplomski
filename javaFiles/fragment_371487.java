public TreeNode getNodeReference (String label) {

    if (check(this, label))
        return this;

    TreeNode childResult = null; 
    if (left != null)
        childResult = left.getNodeReference(label);
    if (childResult == null && middle != null)
        childResult = middle.getNodeReference(label);
    if (childResult == null && right != null)
        childResult = right.getNodeReference(label);

    return childResult;

}