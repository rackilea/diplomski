/**
 * Print all items.
 */
public void printTree( ) {
    printTree( header.right );
}

/**
 * Internal method to print a subtree in sorted order.
 * @param t the node that roots the tree.
 */
private void printTree( RedBlackNode t ) {
    if( t != nullNode ) {
        printTree( t.left );
        System.out.println( t.element );
        printTree( t.right );
    }
}