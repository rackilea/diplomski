public void enqueue(int x) {
    n++;
    if (head == null) {
        head = new Node(x);
    else {
        Node last = head;
        while (last.nextNode != null)
            last = last.nextNode;
        last.nextNode = new Node(x);
    }
}