private void add(int data, Node<Integer> node) {
    if (data < node.data) {
        if (node.left != null) {
            add(data, node.left);
        } else {
            node.left = new Node<>(data);
        }
    }
    else if (data > node.data) {
        if (node.right != null) {
            add(data, node.right);
        } else {
            node.right = new Node<>(data);
        }
        add(data, node.right);
    }
    else if (data == node.data) {
        System.out.println("Duplicate. This value cannot be added to the tree.");
    }
}