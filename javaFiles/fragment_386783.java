ListNode a = new ListNode(1);
ListNode b = new ListNode(2);
ListNode c = new ListNode(3);

ListNode d = a; // variable d now points to object a
d.next = b;     // since d points to a, this statement modifies a.next
d = c           // This does *not* modify a. It just makes d point to c.