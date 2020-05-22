public void flip(Node head, Node tail){ 
    Node temp = new Node();
    temp.data = head.data;
    temp.next = null; // (2)
    tail.next = temp; // (3)
    head = head.next; // (1)
}