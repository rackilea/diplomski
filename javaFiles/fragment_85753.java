public void add(T x) {
    Node newNode = new Node();
    newNode.info = x;

    // case: start is null; just assign start to the new node and return
    if (start == null) {
        start = newNode;
        curr = start;
        // prev is null, hence not formally assigned here
        return;
    }

    // case: new node to be inserted comes before the current start;
    //       in this case, point the new node to start, update pointers, and return
    if (x.compareTo(start.info) < 0) {
        newNode.link = start;
        start = newNode;
        curr = start;
        // again we leave prev undefined, as it is null
        return;
    }

    // otherwise walk down the list until reaching either the end of the list
    // or the first position whose element is greater than the node to be
    // inserted; then insert the node and update the pointers
    prev = start;
    curr = start;
    while (curr != null && x.compareTo(curr.info) >= 0) {
        prev = curr;
        curr = curr.link;
    }

    // splice in the new node and update the curr pointer (prev already correct)
    newNode.link = prev.link;
    prev.link = newNode;
    curr = newNode;
}