private int countLeftNodes(IntTreeNode node)
{
    int c = 0;
    if (node.left != null)
    {
        c += 1 + countLeftNodes(node.left);
    }
    if(node.right != null)
    {
        c += countLeftNodes(node.right);
    }

    return c;
}