public Deque() {
    first = new Node();
    last = new Node();
    first.next = last;
    last.prev = first;  
}