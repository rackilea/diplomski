public ListNode swapPairs(ListNode head) {
    if(head == null || head.next == null) { return head; }

    # swapping the first and second
    ListNode second = new ListNode(head.val);
    ListNode first = new ListNode(head.next.val);
    first.next = second;

    # recursively swap the next 2 items in the linked list till the end of list
    ListNode recursedList = swapPairs(head.next.next);

    first.next.next = recursedList;

    return first;
}