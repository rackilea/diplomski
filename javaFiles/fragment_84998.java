public Golfer min2(BinarySearchTree<Golfer> tree) {
    int treeSize = tree.reset(BinarySearchTree.INORDER);
    if (treeSize <= 0) {
        return null;
    }
    return tree.getNext(BinarySearchTree.INORDER);
}