public BinaryNode<E> flipTree(BinaryNode<E> _root) {
    BinaryNode<E> root = new BinaryNode<>(_root.getItem());
    if (_root.getLeft() != null) {
        root.setRight(flipTree(_root.getLeft());
    }
    if (_root.getRight() != null) {
        root.setLeft(flipTree(_root.getRight());
    }
    return root;
}