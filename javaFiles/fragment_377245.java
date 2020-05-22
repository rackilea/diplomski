public boolean remove(E someElement) {
    if (root == null) {
        return false;
    }
    int val = someElement.compareTo(root.data);
    if (val < 0) {
        return remove(root, false, someElement);
    } else if (val > 0) {
        return remove(root, true, someElement);
    } else {
        root = removeNode(root);
        return true;
    }
}

private boolean remove(Node<E> parent, boolean right, E dataItem) {
    Node<E> node = right ? parent.right : parent.left;
    if (node == null) {
        return false;
    }
    int val = dataItem.compareTo(node.data);
    if (val < 0) {
        return remove(node, false, dataItem);
    } else if (val > 0) {
        return remove(node, true, dataItem);
    } else {
        node = removeNode(node);
        if (right) {
            parent.right = node;
        } else {
            parent.left = node;
        }
        return true;
    }
}