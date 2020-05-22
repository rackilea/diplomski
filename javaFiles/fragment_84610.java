private ListNode merge(ListNode list1, ListNode list2) {
    Listnode head, curr;
    if (list1 == null)
        return list2;
    if (list2 == null)
        return list1;
    if (list1.val <= list2.val) {
        curr = head = list1;
        list1 = list1.next;
    } else {
        curr = head = list2;
        list2 = list2.next;
    }
    while (list1 != null && list2 != null) {
        if (list1.val <= list2.val) {
            curr = curr.next = list1;
            list1 = list1.next;
        } else {
            curr = curr.next = list2;
            list2 = list2.next;
        }
    }
    curr.next = (list1 != null) ? list1 : list2;
    return head;
}