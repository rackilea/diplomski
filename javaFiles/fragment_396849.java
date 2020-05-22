static Node insertAux(Node root, int value) {
if (root == null) {
    root = new Node();
    root.data = value;
    root.left = root.right = null;
} else {
    if (value > root.data) {
        root.right = insertAux(root.right, value);
    } else {
        root.left = insertAux(root.left, value);
    }
}

return root;
}