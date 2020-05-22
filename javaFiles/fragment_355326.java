public static void listAll(LinkedList<String> list)// It is now specific type, 'String'
{
    list.add(new String());//works fine. Compile time it knows that 'list' has 'String'
    for(Object obj : list)
         System.out.println(obj);
}