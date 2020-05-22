public void removeLastIfLargest() {
    if (first == null)          // No elements
        return;
    if (first.getNext() == null) { // First element is alone and hence largest.
        first = null; // remove this line if you don't want this behaviour
        return;
    }
    Node n = first;
    Node p = null; // previous
    int largest = n.getElem();
    while(n.getNext() != null) {
        if (largest < n.getElem()) 
            largest = n.getElem();
        p = n;
        n = n.getNext();
    } 
    if (n.getElem() > largest)  // last is larger than previous largest
        p.setNext(null);
}