public int dis(final Node root, final int g)
{
    int depth = 0;
    for(Node n = root; g != n.data; n = (g < n.data ? n.left : n.right))
        ++depth;
    return depth;
}