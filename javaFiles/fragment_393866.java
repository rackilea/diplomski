public void add(T newEntry) {

   if(newEntry == null) {
       return;
   }
   Node newNode = new Node(newEntry);

   if(isEmpty()) { 
      firstNode = newNode;
   } else if (newNode.data < firstNode.data) {
      // make newNode point to the firstNode,
      // and then re-assign firstNode
      newNode.setNextNode(firstNode);
      firstNode = newNode;
   } else {
       Node currentNode = firstNode;
       Node nextNode = currentNode.getNextNode;
       while (nextNode != null && nextNode.data > newNode.data) {
           currentNode = nextNode;
           nextNode = currentNode.getNextNode;
       }
       // insert newNode between currentNode and nextNode
       newNode.setNextNode(nextNode);
       currentNode.setNextNode = newNode;
   }
   length++;
   return;     
}