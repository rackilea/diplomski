public int nth(int n) throws NoSuchElementException {
if( sizeOfTree(this.root) < n || n < 1)
    throw new NoSuchElementException("Element " + n + " not found in tree");

BTNode<Integer> root = this.root;
boolean found = false;
do{
    int sizeOfLeftSubtree = sizeOfTree(root.left);
    if( sizeOfLeftSubtree + 1 == n ){
    found = true;
    }else if( n < sizeOfLeftSubtree+1 ){
    root = root.left;
    }else if( sizeOfLeftSubtree+1 < n ){
    root = root.right;
    n -= sizeOfLeftSubtree+1;
    }
}while( !found );

return root.data;
}

public int sizeOfTree(BTNode<Integer> root){
if( root == null )
    return 0;
else
    return sizeOfTree(root.left) + 1 + sizeOfTree(root.right);
}