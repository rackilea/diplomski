private swapPrevPointer(Item a, Item b) {
   Item temp = a.prev;
   a.prev = b.prev;
   b.prev = temp;
}

private swapNextPointer(Item a, Item b) {
   Item temp = a.next;
   a.next = b.next;
   b.next = temp;
}