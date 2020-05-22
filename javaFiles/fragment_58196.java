public void printStack()
{
    Node copy = first;
    while(copy!=null)
    {   
        System.out.println(copy.item);
        copy = copy.next;
    }
}