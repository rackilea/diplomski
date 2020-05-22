ListNode dummy = new ListNode(0); // Line 1
dummy.next =  head; // Line 2
ListNode prev = dummy; // Line 3
ListNode slow = head; // Line 4
head.next = null; // Line 5
prev.next = slow; // Line 6

ListNode temp = slow.next; // Line 7
prev.next = temp; // Line 8

System.out.println(dummy.next); // Line 9