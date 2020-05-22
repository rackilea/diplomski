public static Node reverseRecurseDoubleLinkedList(Node node) {
    if (node == null) {
        return node;
    }

    if (node.next == null) {
        node.prev = null;
        return node;
    }

    Node newHead = reverseRecurseDoubleLinkedList(node.next);
    node.next.next = node;
    node.prev = node.next;
    node.next = null;

    return newHead;
}