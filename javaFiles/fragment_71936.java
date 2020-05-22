public void flipTree(BinaryNode<E> root) {
    BinaryNode<E> temp = root.getLeft();
    root.setLeft(root.getRight());
    root.setRight(temp);
    if (root.getLeft() != null) {
        flipTree(root.getLeft());
    }
    if (root.getRight() != null) {
        flipTree(root.getRight());
    }
}