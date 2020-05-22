public void deleteSec() {
    if (head == null) {
        return;
    }
    if (head.next == null) {
        return;
    }
    if (head.next.next == null) {
        head = head.next;
        return;
    }
    Node current = head;
    Node p = current.next;
    Node q = p.next;
    while (q.next != null) {
        current = current.next;
        p = p.next;
        q = q.next;
    }
    current.next = q;
}