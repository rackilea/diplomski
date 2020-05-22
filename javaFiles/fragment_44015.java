current = head;
    prev = null;
    while( current != null && current.next != null ){
        next = current.next;

        if( current.iData > next.iData ) {
            // need to swap nodes
        if( prev == null ) {
            // special head case
            head = next;
            current.next = head.next;
            head.next = current;
            }
        else
        {
            prev.next = next;
            current.next = next.next;
            next.next = current;
        }
    }

    // increment pointer
    prev = current;
    current = current.next;
}