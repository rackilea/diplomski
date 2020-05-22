public void swapPairwiseIteratively() {
  if(first == null || first.next==null) return;
  Node one = first, two = first.next, prev = null;
  first = two;
  while (one != null && two != null) {
    // the previous node should point to two
    if (prev != null) prev.next = two;
    // node one should point to the one after two
    one.next = two.next;
    // node two should point to one
    two.next = one;
    // getting ready for next iteration
    // one (now the last node) is the prev node
    prev = one;
    // one is prev's successor
    one = prev.next;
    // two is prev's successor's successor
    if (prev.next != null) two = prev.next.next;
    else two = null;
  }
}