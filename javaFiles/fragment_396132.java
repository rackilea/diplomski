Map<String,Salary>  map  = new HashMap<String,Salary>();
    for (Salary s : list)
    {
        Salary e = map.get(s.getSortedNames());
        if (e == null)
            map.put(s.getSortedNames(), s);
        else
            e.amount += s.amount;
    }