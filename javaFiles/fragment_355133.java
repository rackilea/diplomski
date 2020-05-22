public int getCount(E key) {
    if (key == null) {
        return -1;
    }
    int N = 0;
    Node curr = first;
    while (curr != null) {
        if (curr.key.equals(key)) {  // change made here 
            N++;
        }
        curr = curr.next;
    }
    return N;
}