public boolean isLinkedToStart(Node head) {
    if (head == null) {
        return false;
    }
    Node fast = head.next;
    Node slow = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        if(slow.next == head)
            return true;
        if (fast == slow)
            return false;
    }
    return false;
}