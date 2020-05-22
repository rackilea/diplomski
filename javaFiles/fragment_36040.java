public void sumNode(TNode<E> root) {
    // For empty trees, do nothing.
    if (root == null)
        return;

    // Update the left subtree recursively.
    sumNode(root.left);

    // Update the right subtree recursively.
    sumNode(root.right);

    // At this point, all the elements in the left and right
    // subtrees are already summed up. Now we update the
    // sum in the root element itself.
    if (root.left != null)
        root.item += root.left.item;
    if (root.right != null)
        root.item += root.right.item;
}