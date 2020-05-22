class FastIndexLinkedIntList<X> {
   class Node {
      Node next;
      Node prev;
      int key;
      X value;
      Node(int key, X val) { this.key = key; this.value = val; }
   }

   ArrayList<Node> indexedNodes = new ArrayList<Node>();
   Node head;
   Node tail;


   public void add(X value) {
      int key = indexedNodes.size();
      Node node = new Node(key, value);
      insertAtEnd(node);
      indexedNodes.add(node);
   }

   private void insertAtEnd(Node n) {
      if(tail == null) {
         assert head == null;
         head = n;
         tail = n;
         return;
      }
      n.prev = tail;
      n.next = null;
      tail.next = n;
      tail = n;
   }

   private void removeNode(Node n) {
      if(n.next == null) {
         assert n == tail;  // last node

         tail = n.prev;
         tail.next = null;
      }
      else {
         n.next.prev = n.prev;
      }

      if(n.prev == null) {
         assert n == head; // first node

         head = n.next;
         head.prev = null;
      }
      else {
         n.prev.next = n.next;
      }
   }

   public void moveNodeToEnd(int key) {
      Node n = indexedNodes.get(key);
      removeNode(n);
      insertAtEnd(n);
   }

}