public int dis(final Node n, final int g)
{
    if(g == n.data)
        return 0;
    else
        return 1 + dis(g < n.data ? n.left : n.right, g);
}