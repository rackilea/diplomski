int totalnodes(Node root){
    if(root==null)return 0;
    int lc=totalnodes(root.left);
    int rc=totalnodes(root.right);
    return rc+lc+1;
}