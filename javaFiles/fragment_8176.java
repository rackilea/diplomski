private static Node getSecondHalfByCreatingNewNodes(Node head) {
    Node mid = getMiddleNode(head);
    Node newHead = new Node(mid.data);
    mid = mid.next;
    Node tail = newHead, temp;
    while(mid != null) {
        temp = new Node(mid.data);
        tail.next = temp;
        tail = temp;
    }
    return newHead;
}

private static Node getMiddleNode(Node head) {
    Node fastRunner = head, slowRunner = head;
    while(fastRunner != null && fastRunner.next != null) {
        slowRunner = slowRunner.next;
        fastRunner = fastRunner.next.next;
    }
    return slowRunner;
}