public void advance() {
    if (current != null) {
        tail = current;
        current = tail.next; // tail.next = current!
    }
}