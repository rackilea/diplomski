public void addNode(int value) { // public method is called by the object and this public method calls the private method in which the root is also passed.
    root = add(root, value);
}
private Node add(Node node, int value) {
    if(node == null) {
        node = new Node(value);
    }
    else if(value == node.data) {
        node.data = value;
    }
    else if(value < node.data) {
        node.left = add(node.left, value);
    }
    else {
        node.right = add(node.right, value);
    }
    return node;
}