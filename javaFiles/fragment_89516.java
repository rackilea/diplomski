ListNode common  = new ListNode(8);
common.next = new ListNode(4);
common.next.next = new ListNode(5);

ListNode listA0 = new ListNode(4);
listA0.next = new ListNode(1);
listA0.next.next = common;


ListNode listB0 = new ListNode(5);
listB0.next = new ListNode(0);
listB0.next.next = new ListNode(1);
listB0.next.next.next = common;