while(i.hasNext()) 
{
    Map.Entry me = (Map.Entry)i.next();
    System.out.print(me.getKey() + ": ");
    String[] value = (String[])me.getValue();
    for(String str:value)
    {
        System.out.println(str+"\t");
    }
    System.out.println();
}