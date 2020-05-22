public void firstLast() {
    // list is empty or has single element -> nothing to do
    if (front == null || front.next == null) {
        return;
    }

    // save the first
    ListNode first = front;

    // move the head
    front = front.next;

    // find the end
    ListNode current = front;
    while (current.next != null) {
        current = current.next;
    }

    // append the node
    current.next = first;

    // reset the next pointer of the new last node
    first.next = null;
}