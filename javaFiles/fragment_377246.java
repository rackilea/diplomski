private boolean remove(Node<E> parent, boolean right, E dataItem) {
    while (true) {
        Node<E> node = right ? parent.right : parent.left;
        if (node == null) {
            return false;
        }
        int val = dataItem.compareTo(node.data);
        if (val < 0) {
            right = false;
        } else if (val > 0) {
            right = true;
        } else {
            node = removeNode(node);
            if (right) {
                parent.right = node;
            } else {
                parent.left = node;
            }
            return true;
        }
        parent = node;
    }
}