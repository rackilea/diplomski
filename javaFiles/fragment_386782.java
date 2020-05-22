ListNode fast = head, slow = head; // fast = head = (1)
fast = fast.next.next;             // fast = fast.next.next = (3). head is still (1)
printLinkedNode(fast);             // 3->4 -> because fast points to head.next.next (3)
printLinkedNode(head);             // 1->2->3->4 -> head wasn't modified by any of the previous instructions

// here fast points to head.next.next. So fast.next is the same as head.next.next.next (4).
fast.next = new ListNode(5);       // Overwrites fast.next, it was (4), becomes (5)
printLinkedNode(fast);             // 3->5
printLinkedNode(head);             // 1->2->3->5