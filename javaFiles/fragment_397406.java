public static void deleteDuplicates(ListNode head) {
    ListNode result = head;

    if (head == null)
        return;
    // System.out.println(listNodetoString(result));

    while (result.next != null) {
        if (result.val == result.next.val)
            result.next = result.next.next;
        else
            result = result.next;
    }
}