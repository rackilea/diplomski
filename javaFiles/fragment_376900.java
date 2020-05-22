Node concat(Node list1, Node list2) {
    Node clone = copy(list1);
    Node iter = clone;
    while (iter.next != null) {
        iter = iter.next;
    }
    iter.next = copy(list2);
    return clone;
}

Node copy(Node other) {
    Node clone = new Node(other.data);
    Node iter = clone;
    while (other.next != null) {
        other = other.next;
        iter.next = new Node(other.data);
        iter = iter.next;
    }
    return clone;
}