public void getBegintijd()
{
    if (!verhuur.isEmpty())
        System.out.println(verhuur.iterator().next().getBegintijd());   
    else
        System.out.println("empty set");
}