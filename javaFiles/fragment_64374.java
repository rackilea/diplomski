void clearTree(treenode *node) {
    if (node != NULL) {
        clearTree( node->leftChild );
        clearTree( node->rightChild );
        delete( node ); // Or in Java, node = null;
    }
}