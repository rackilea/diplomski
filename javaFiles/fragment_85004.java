public Node getLast(Node head) {
    Node current = head;
    while(current.next != null) {
        current = current.next;
    }

    return current;
}

public void sort() {
    Node la = getLast(head);
    quickSort(head, la);
    head = actualHead;
}

public void quickSort(Node head, Node last) {

    if(head == last)
        return;
    if(head == null || last == null)
        return;
    if(last.next == head)
        return;

    Node partition = partition(head, last);

    Node newHead = this.head;
    Node newTail = this.last;


    quickSort(newHead, partition.prev);

    if(actualHead == null)
    {
        actualHead = newHead;
    }

    quickSort(partition.next, newTail);

}

public Node partition(Node head, Node last) {
    Node current = head;
    Node p = last;

    while(current != p) {

        if(current.data > p.data) {
            Node next = current.next;
            current.next.prev = current.prev;
            if(current.prev != null)
                current.prev.next = current.next;
            current.next = last.next;
            current.prev = last; 
            last.next = current;

            if(current == head)
                head = next;
            last = current;
            current = next;
        }
        else {
            current = current.next;

        }
    }
    this.head = head;
    this.last = last;
    return p;
}