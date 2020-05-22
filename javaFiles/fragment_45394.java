/*Deletes the last node in the list*/
public void remove() {
  if(head == null || size == 0) return; // Empty list
  if(head == current || size ==1){    // List with only one node
    head = null;
    current = null;
    size--;
    return;
  }
  DNode<T> previous = current.prev;
  previous.next = current.next;
  current.prev = null;
  current = previous;
    size--;
}