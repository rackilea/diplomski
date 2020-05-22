public int size()
{
    for(Node n = header; n.getNext() != null; n = n.getNext())
    {
        size++;
    }
    return size;
}