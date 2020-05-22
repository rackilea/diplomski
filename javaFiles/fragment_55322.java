public E get(int index){
  if(index < 0 || index >= size)
    throw new IndexOutOfBoundsException();

  Node<E> current = head;
  for(int i = 0; i < index; i++) {
    current = current.getSuccessor();
  }
  return current.getElement();
}