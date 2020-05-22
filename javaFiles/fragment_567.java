public BinaryTreeNode<E> inOrderIdSearch(BinaryTreeNode<E> n, int usrId) {
    if (n==null) {
        return null;
    }
    if (n.getValue().getId() == usrId) {
        return n;
    }
    BinaryTreeNode<E> leftResult =inOrderIdSearch(n.getLeft(),usrId);    
    if (leftResult!=null) {
        return leftResult;
    }
    BinaryTreeNode<E> rightResult = inOrderIdSearch(n.getRight(),usrId);
    if (rightResult != null) {
        return rightResult;
    }
}