public Golfer min(BinarySearchTree<Golfer> tree) {
    BSTNode<Golfer> node = tree.root;
    if (node == null) {
        return null;
    }
    while (node.getLeft() != null) {
        node = node.getLeft();
    }
    return node.getInfo();
}