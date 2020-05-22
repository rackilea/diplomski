public Link getEnd(LinkedList a) {
    if (a.head == null) return null; // Empty list.
    Link previous = null, current = a.head;
    while(current.next != null) {
        previous = current;
        current = current.next;
    }
    // Figure out what to do now yourself. It's easy.
}