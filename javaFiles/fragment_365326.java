public void removeOdds() {
    if (size <= 1) {
        return;
    } else {
        Node cur = head;
        Node previous = cur;
        while (cur.next != tail) {
            cur = cur.next;
            if (cur.getElement() % 2 != 0) {
                size--;
                previous.next = cur.next;
            } else {
                previous = previous.next;
            }
        }
    }
}