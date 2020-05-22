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
        tempCurr.prev = temp;
        // Think very carefully what this next line does.
        // You've just overwritten tempCurr.prev with temp.
        // This means you've now assigned temp.next = temp
        // That's going to create a cycle.
        tempCurr.prev.next = temp;
    }
}