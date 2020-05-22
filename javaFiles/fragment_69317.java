public Set<String> getEvens()
{
    Set<String> evens = new TreeSet<String>();
    for (String a : list)
    {
        int x =Integer.parseInt(a);
        if (x % 2==0)
        {
            evens.add(a);
        }
    }
}