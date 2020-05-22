// this method returns the head of the new list with the item possibly removed
public Node remove (K key) {
V result = null;
if (this.isEmpty()) {
    return null;                          // return null for empty list
} else if (head.getKey().equals(key)) {
    return head.getNextNode();            // return head if head matches
} else {
   Node current = head;
   Node next = head.getNextNode();

   while (next != null) {                 // walk down the list and search
       if (next.getKey().equals(key)) {
           current.setNextNode(next.getNextNode());
           break;
       }
       current = next;                    // advance list pointers
       next = next.getNextNode();
    }

    return head;                          // will return head for list with 1 element
    }
}