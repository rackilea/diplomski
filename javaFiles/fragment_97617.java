/**
  * Pointer to last node.
  * Invariant: (first == null && last == null) ||
  *            (last.next == null && last.item != null)
  */
transient Node<E> last;