class TraversalState {
    public int rank = 0;
}
...
public int inOrderTraversal(TreeNode node, int n, TraversalState ts){
    if(node==null)
        return 0;
    int x=inOrderTraversal(node.left,n, ts);
    ts.rank++;
    if(n==ts.rank) return node.data;
    int y=inOrderTraversal(node.right,n, ts);
    int c= x==0 ? y:x;
    return c;
}