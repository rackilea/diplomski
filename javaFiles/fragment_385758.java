public void add(int data) {
    Node n = new Node(data); 
    n.next = null;

    if (head == NULL) {
        head = n;
    } else {
        tail->next = n;
    }

    tail = n;
}