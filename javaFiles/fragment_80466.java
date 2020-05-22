private static Map<String, Person> sortByComparator(Map<String, Person> unsortMap, Comparator<Person> cmp, final boolean order)
{

    List<Entry<String, Person>> list = new LinkedList<>(unsortMap.entrySet());

    // Sorting the list based on values
    Collections.sort(list, new Comparator<Entry<String, Person>>()
    {
        @Override
        public int compare(Entry<String, Person> o1, Entry<String, Person> o2)
        {
            if (order)
            {
                return cmp.compare(o1.getValue(),o2.getValue());
            }
            else
            {
                return cmp.compare(o2.getValue(),o1.getValue());
            }
        }
    });

    // Maintaining insertion order with the help of LinkedList
    Map<String, Person> sortedMap = new LinkedHashMap<>();
    for (Entry<String, Person> entry : list)
    {
        sortedMap.put(entry.getKey(), entry.getValue());
    }

    return sortedMap;
}