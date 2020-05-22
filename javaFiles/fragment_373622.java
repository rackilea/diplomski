void insert(int x) {
    LinkedList newLink = new LinkedList(x);
    if (front == null) {
        front = newLink;
        // insert in head if x is lower than the head
    } else if (x <= front.x) {
        newLink.next = front;
        front = newLink;
    } else {
        // find the first node which value is lower than x (or the tail)
        LinkedList current;
        for (current = front; current.next != null && x >= current.next.x ; current = current.next);
        // to remove duplicates
        if (x != current.x) {
            newLink.next = current.next;
            current.next = newLink;
        }
    }
}