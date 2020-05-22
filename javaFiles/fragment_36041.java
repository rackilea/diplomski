private void preprocessTree(TNode<E> root) {
    if (root == null)
        return;

    preprocessTree(root.left);
    preprocessTree(root.right);
    root.originalItem = root.item;
}

private void processTree(TNode<E> root) {
    if (root == null)
        return;

    processTree(root.left);
    processTree(root.right);
    if (root.left != null)
        root.item += root.left.item;
    if (root.right != null)
        root.item += root.right.item;
}

private void postprocessTree(TNode<E> root) {
    if (root == null)
        return;

    postprocessTree(root.left);
    postprocessTree(root.right);
    root.item -= root.originalItem;
}

public void sumTree(TNode<E> root) {
    preprocessTree(root);
    processTree(root);
    postprocessTree(root);
}