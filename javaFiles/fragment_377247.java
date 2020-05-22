private Node<E> removeNode(Node<E> parent) {
    if (parent.left == null) {
        return parent.right;
    } else if (parent.right == null) {
        return parent.left;
    }
    boolean right = random.nextBoolean();
    Node<E> node = right ? parent.right : parent.left;
    Node<E> last = removeLast(node, !right);
    if (last == null) {
        if (right) {
            node.left = parent.left;
        } else {
            node.right = parent.right;
        }
        return node;
    } else {
        last.left = parent.left;
        last.right = parent.right;
        return last;
    }
}

private Node<E> removeLast(Node<E> parent, boolean right) {
    Node<E> node = right ? parent.right : parent.left;
    if (node == null) {
        return null;
    }
    while (true) {
        Node<E> next = right ? node.right : node.left;
        if (next == null) {
            break;
        }
        parent = node;
        node = next;
    }
    if (right) {
        parent.right = node.left;
        node.left = null;
    } else {
        parent.left = node.right;
        node.right = null;
    }
    return node;
}