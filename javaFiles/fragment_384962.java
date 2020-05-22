void insert (Node node, int value) {
    while (true) {
        if (value < node.value) {
            if (node.left == null){
                node.left = new Node(value);
                break;
            }
            else
                node = node.left;
        }
        else {
            if (node.right == null){
                node.right = new Node(value);
                break;
            }
            else
                node = node.right;
        }
    }
}