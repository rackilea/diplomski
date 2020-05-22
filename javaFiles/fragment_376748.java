public void addList(LinkedList<T> list)
{
    Node current = head;

    while (current.getNext() != null)
    {
        current = current.getNext();
    }
    current.setNext(list.getFirst()); //Try this

}