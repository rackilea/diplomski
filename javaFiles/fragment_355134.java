public boolean insert(E key) {
    if (first == null || first.key != key) {
        first = new Node(key, first);
    } else {
        Node curr = first;
        while (curr.next != null) {  // iterate till the end of the list
            curr = curr.next; 
        }
        curr.next = new Node(key);   // point last node's next ref to new node
        N++;
    }
    return true;
}