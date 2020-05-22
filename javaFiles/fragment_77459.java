public void enQueue(Node x) {
    if (firstSentinel.next == lastSentinel)// list is empty
    {
        firstSentinel.next = x;
        x.prev = firstSentinel;
        x.next = lastSentinel;
        lastSentinel.prev = x;
    } else {
        Node temp = x;
        Node curr = firstSentinel.next;
        while (curr != lastSentinel && temp.value <= curr.value) {
            curr = curr.next;
        }
        Node tempCurr = curr;
        temp.next = tempCurr;
        temp.prev = tempCurr.prev;
        tempCurr.prev.next = temp;
        // Note here that the assignment to tempCurr.prev happens
        // after the assignment to tempCurr.prev.next
        tempCurr.prev = temp;
    }
}