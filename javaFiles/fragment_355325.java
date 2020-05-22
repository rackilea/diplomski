public static void listAll(LinkedList list) 
{
    list.add(new String());  //works fine
    for(Object obj : list)
            System.out.println(obj);

}
public static void listAll(LinkedList<?> list) 
{
     list.add(new String());  //compile time error. Only 'null' is allowed.
     for(Object obj : list)
          System.out.println(obj);
}