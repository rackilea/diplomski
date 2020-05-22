1 public Node s(Node head) {
 2     // if only 1 node or null node return it
 3     if (head == null || head.next == null) {
 4         return head;
 5     }
 6 
 7     Node slow = head.next;
 8     head.next = head.next.next;
 9     slow.next = head;
10     head = slow;
11     Node parent = slow.next;
12     slow = slow.next.next;
13
14     while (slow != null && slow.next != null) {
15         Node temp = slow.next;
16         slow.next = slow.next.next;
17         temp.next = slow;
18         parent.next = temp;
19         parent = parent.next.next;
20         slow = slow.next;
21     }
22     return head;
23 }