public BinaryNode insert(BinaryNode node, int x) {

    if (node == null) {
        node = new BinaryNode(x);
    } else if (x < node.element) {
        node.left = insert(node.left, x);
    } else if (node.element < x) {
        node.right = insert(node.right, x);
    } else {
        System.out.println("Duplicates not allowed");
    }

    return node;
}