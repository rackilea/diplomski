public void remove(Node item) {
    Node prev = item.prev;
    Node next = item.next;

    prev.next = next;
    next.prev = prev;

    item.next = null;
    item.prev = null;
}