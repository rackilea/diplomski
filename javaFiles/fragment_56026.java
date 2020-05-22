public void print()
{
   for(Node temp = head; temp != null; temp = temp.next)
   {
       System.out.println(temp.name);
   }
}

public void printReverse()
{
   for(Node temp = tail; temp != null; temp = temp.prev)
   {
       System.out.println(temp.name);
   }
}