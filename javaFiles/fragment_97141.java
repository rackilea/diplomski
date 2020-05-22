Iterator<Integer> itr=myTreeSet.iterator();
while(itr.hasNext())
{
    int check = itr.next();
    for(Map.Entry<String, List<Integer>> entry : map2.entrySet())
    {
        if(entry.getValue() != null && entry.getValue().contains(check))
        System.out.println("The key " + entry.getKey() + "contains the treeset value " + check);

    }
}