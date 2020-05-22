public void add(X v)
{
    Node<X> a = new Node<X>();
    a.setValue(v);
    if(head==null)
        head = a;
    else
    {
        Node<X> tail = getTail();
        tail.setLink(a);
    }
    count++;
}
private Node<X> getTail(){
    if(head==null)
        return null;
    Node<X> current = head;
    while(current.getLink()!=null)
        current = current.getLink();
    return current;
}