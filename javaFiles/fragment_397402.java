public static ListNode deleteDuplicates(ListNode head) {
    ListNode result = head;

    if (head == null)
        return head;
    // System.out.println(ListNodetoString(result));

    while (result.next != null) {
        if (result.val == result.next.val)
            result.next = result.next.next;
        else
            result = result.next;
    }
    return head;
}