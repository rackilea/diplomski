public void reverse() {
    ListNode cursor = head;
    ListNode newHead = null;

    while (cursor != null) {
        ListNode next = cursor.next;
        cursor.next = newHead;
        newHead = cursor;
        cursor = next;
    }
    head = newHead;
}