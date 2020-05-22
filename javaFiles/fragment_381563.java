public <T> void printLinkedListFromHead(LinkedList<T> list) {

   for(ListIterator<T> iterator = list.listIterator(0); iterator.hasNext();) {
       System.out.println(iterator.next());
   }

 }