public void postOrderTraverseRecursive(Node r){
    if(r == null){return;}

    if (r.left != null){
        postOrderTraverseRecursive(r.left);}
    if(r.right != null){
        postOrderTraverseRecursive(r.right);}

    System.out.print(r);
}