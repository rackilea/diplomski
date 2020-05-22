public void display()
{
    LinkedListImp temp = this;
    StringBuilder result = new StringBuilder();
    while(temp.next!=null)
    {
        result.insert(0, "\n\t"+ temp.element +"\n"); // put the result at the front
        temp=temp.next;
    }
    System.out.println(result.toString());
}