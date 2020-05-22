public boolean isLeaf(RedBlackNode<AnyType> t ){
if(t.left == null && t.right == null){
return false;
}
return true;
}