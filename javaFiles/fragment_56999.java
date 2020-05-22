Iterator it = map.keySet().iterator();
    while (it.hasNext())
    {
        String id = (String)it.next();
        Collection<?> values = map.getCollection(id);
        // loop on values and do whatever you need ...
    }