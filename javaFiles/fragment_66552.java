private static <E> Node<E> insertNodeAtPosition(Node<E> prev, Node<E> head, E element, int position) {
    if (position == 0) {
        Node<E> newNode = new Node<>(element, null);

        if (prev != null) {
            prev.next = newNode;
        }

        newNode.next = head;

        return newNode;
    }

    return insertNodeAtPosition(head, head.next, element, position - 1);
}