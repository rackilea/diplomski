private void swapWithPrevious(Node node) {
   if(n.previous == null) { // first node
       return;
   }

   Node p = node.previous;
   Node pp = p.previous;
   Node n = node.next;
   if(pp != null) {
       pp.next = node;
   }
   node.previous = pp;
   node.next = p;
   p.previous = node;
   p.next = n;
   if(n != null) {
       n.previous = p;
   }
}