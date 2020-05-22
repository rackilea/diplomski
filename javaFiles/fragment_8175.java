private static Node getSecondHalfInSameList(Node head) {
    Node fastRunner = head, slowRunner = head;
    while(fastRunner != null && fastRunner.next != null) {
        slowRunner = slowRunner.next;
        fastRunner = fastRunner.next.next;
    }
    return slowRunner;
}