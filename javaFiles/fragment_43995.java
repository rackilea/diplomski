public boolean reverseTillIndex(int index) {
    int count = 0;
    if (index == 0) {
        return false;
    }
    Node endCountNode = head;

    while (count++ < index && endCountNode != null) {
        endCountNode = endCountNode.next;
    }
    count = 0;

    // standard reverse a list code
    Node current = head;
    Node h2 = null;

    while (current != null && count++ < index) {
        head = current.next;
        current.next = h2;
        h2 = current;
        current = head;
    }

    head = h2;
    while (h2.next != null) {
        h2 = h2.next;
    }
    h2.next = endCountNode;
    return true;
}