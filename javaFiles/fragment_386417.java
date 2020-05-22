public boolean add(E element) 
{
    for (Node ref = first; ref != null; ref = ref.next)
    {
        if (element.equals(ref.data)) {
            return false;
        }
    }
    Node newFirst = new Node(element);
    newFirst.next = first;
    first = newFirst;
    return true;
}