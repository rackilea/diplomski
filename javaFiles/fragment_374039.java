void add(int data) {
    if (root.data == 0)
        root.data = data;
    else {
        Node new_node = new Node(data);
        new_node.next = root;
        root = new_node;
    }
}