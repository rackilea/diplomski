boolean isBalanced(Node node) 
{
    int lh;
    int rh;

    if (node == null)
        return true;

    lh = height(node.left);
    rh = height(node.right);

    if (Math.abs(lh - rh) <= 1
            && isBalanced(node.left)
            && isBalanced(node.right)) {
        return true;
    }
    return false;
}