Node insertNth(Node head, int data, int position) {
    Node dummy = new Node();
    dummy.next = head;

    Node runner = dummy;
    for (int i = 0; i < position; ++i) {
        runner = runner.next;
    }

    Node node = new Node();
    node.data = data;
    node.next = runner.next;
    runner.next = node;

    return dummy.next;
}