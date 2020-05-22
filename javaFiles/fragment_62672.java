public static void howmany (ArrayList <String> list)
{
    Set<String> processed = new HashSet<>();
    for (int i=0; i<list.size();i++)
    {
        if(!processed.contains(list.get(i))) {
            System.out.println(list.get(i) + ": " + Collections.frequency(list, list.get(i)));
            processed.add(list.get(i));
        }
    }
}