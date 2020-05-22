Node sortedInsert(Node head, int data) {
    Node newnode = new Node();
    newnode.data = data;

    // head is null -> new Node is new list
    if (head == null)
        return newnode;

    // handle special case if data < head.data
    if (data < head.data) {
        newnode.next = head;
        head.prev = newnode;
        return newnode; // newnode is the new list head
    }

    // search position in list
    Node prev = head;
    for (; prev.next != null; prev = prev.next) {
        if (prev.next.data > data)
            break;
    }

    // insert behind prev
    newnode.next = prev.next;
    if (prev.next != null) {
        prev.next.prev = newnode;
    }
    prev.next = newnode;
    newnode.prev = prev;

    return head; // head did not change
}