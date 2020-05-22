static Node RemoveDuplicates(Node head) {
    if (head == null) return null;

    Node current = head;
    Node runner = head;

    while (current != null && current.next != null) {
        runner = current.next;
        while (runner != null && runner.data == current.data) {
            current.next = runner.next; // skip the repeat
            runner = runner.next;
        }
        current = current.next;
    }
    return head;
}