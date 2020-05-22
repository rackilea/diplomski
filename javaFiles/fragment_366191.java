Node SortedInsert(Node head,int data) {

    Node newn = new Node();
    newn.data = data;  

    Node ptr = head;

    if (ptr == null) {
        head = newn;

    } else if ( ptr.data > newn.data ) {
        newn.next = ptr;
        ptr.prev = newn;
        head = newn;

    } else {
        Node nex = head.next;

        while (nex != null && nex.data <= newn.data) {
            ptr = nex;
            nex = nex.next;
        }

        ptr.next = newn;
        newn.prev = ptr;

        if (nex != null) {
            nex.prev = newn;
            newn.next = nex;
        }
    }

    return head;   
}