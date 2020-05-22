class MyLinkedList<T extends MyLinkedList<T>> {
  public T next;
}

class MyExtendedLinkedList extends MyLinkedList<MyExtendedLinkedList> {
  ...
}