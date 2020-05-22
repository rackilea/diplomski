public void findDNode(String name)
{
    DNode u = header;
    while(u != null)
    {

        if(name == u.getElement())
        {
            System.out.println(u.getElement());
            break;
        }

        u = u.nextNode();
    }
   if (u==null)
       System.out.println("Error: not found");

}