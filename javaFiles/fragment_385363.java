else
{
    Node cn = head;
    while (cn.next != null)
    {
        cn = cn.next;
    }
    cn.next = new Node(d);
}