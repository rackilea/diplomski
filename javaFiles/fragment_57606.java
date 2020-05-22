static Node sol(Node head, Node prev) {
    if (head == null) {
        return null;
    }
    else if (head.next == null) {
        head.next = prev;
        return head;
    }

    Node tail = sol(head.next, head);
    head.next = prev;
    return tail;
}