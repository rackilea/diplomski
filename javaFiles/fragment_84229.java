public void placeAtBeginning(E element)
{
  Node<E> newNode = new Node<E>(element);
  if(head == null)
  {
    head = newNode;
    head.setNext(head);
  }
  else
  {
    Node<E> last = head;
    while (last.getNext() != head)
      last = last.getNext();
    newNode.setNext(head);
    head = newNode;
    last.setNext(head);
  }
  size++;
}