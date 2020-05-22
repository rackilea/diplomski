public void insert(T element) {
    insert(element, first);    // initialization
}

private void insert(T e, Node n) {
    if(n == null) {            // if the list is empty
        first = new Node(e);
    } else if(n.next == null) {       // same condition as in the while loop
        None newNode = new Node(e);
        n.next = newNode;
        newNode.prec = n;
    } else {
        insert(e, n.next);    // looping
    }
}