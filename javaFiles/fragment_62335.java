public void display()
{
    LinkedListImp temp = this;
    while(temp.next!=null)
    {
        System.out.println("\n\t"+ temp.element +"\n");
        temp=temp.next;
    }
}