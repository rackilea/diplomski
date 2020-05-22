public void add(T newEntry) {

   if(newEntry == null) {
       return;
   }

   if(isEmpty()) { 
      firstNode = new Node(newEntry);
   } else {
       Node currentNode = firstNode;
       if(newEntry.compareTo(firstNode.data)<0) {
// Here you're assigning a new value to firstNode, but not linking to the old
// firstNode. So you're losing the entire list.
           firstNode = new Node(newEntry, firstNode);
           length++;
           return;
       } else {
           while(currentNode.getNextNode() != null && newEntry.compareTo(currentNode.next.data) > 0) {
                  currentNode = currentNode.next;
// Here you're adding multiple new nodes to the list.
                  currentNode.setNextNode(new Node(newEntry, currentNode.getNextNode()));
           }
       }
   }
   length++;
   return;     
}