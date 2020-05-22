public void enQueue(Node x) {
    Node curr = firstSentinel.next;
    while (curr != lastSentinel && x.value <= curr.value) {
        curr = curr.next;
    }
    Node tempCurr = curr;
    x.next = tempCurr;
    x.prev = tempCurr.prev;
    tempCurr.prev.next = x;
    tempCurr.prev = x;
}