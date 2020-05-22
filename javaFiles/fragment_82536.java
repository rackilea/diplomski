public void swap(int index) {
    Node prev;
    Node next;
    Node current = start;
    //special treatment, as the head changes!
    if (0 == index) {
        //define
        next = current.next;
        //do the swap
        current.next = next.next;
        next.next = current;
        start = next;   // the head changes!
        return;
    }
    //stop one before the one you need to swap(index-1)
    for (int i = 0; i < index - 1; i++) {
        current = current.next;
        System.out.println("Value is: " + current.value);
    }
    //define
    prev = current;
    current = prev.next;
    next = current.next;
    // do the swap:
    prev.next = next;
    current.next = next.next;
    next.next = current;
}