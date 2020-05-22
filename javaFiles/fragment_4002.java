public Node delete(Object data) {
    Node node = this;
    if (node.data.equals(data)) {
        return node.next;
    }
    while (node.next != null) {
        if (node.next.data.equals(data)) {
            node.next = node.next.next;
            return node;
        }
        node = node.next;
    }
    return null;
}