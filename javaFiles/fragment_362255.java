//when instantiated, MagazineList's  list variable is set to null
public void add (Magazine mag) {

   ListNode node = new ListNode (mag, null);
   ListNode current;

   if (list == null)
     list = node;
   else {
    current = list; // you list head
    while (node.compareTo(current) < 0)
       current = current.getNext();
   ListNode next = current.getNext();
   current.setNext(node);
   node.setNext(next);
   }
}