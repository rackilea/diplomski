public void reverse()
{
    Node current = first;
    while (current != null) {
        Node next = current.next;
        current.next = current.prev;
        current.prev = next;
        current = next;
    }
    Node temp = first;
    first = last;
    last = temp;
}