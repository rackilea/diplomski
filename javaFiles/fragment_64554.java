// try this
public ListNode removeDuplicateElements(ListNode head) {
    if (head == null || head.next == null) {
        return null;
    }
    if (head.data.equals(head.next.data)) {
        ListNode next_next = head.next.next;
        head.next = null;
        head.next = next_next;
        removeDuplicateElements(head);
    } else {
        removeDuplicateElements(head.next);
    }
    return head;
}