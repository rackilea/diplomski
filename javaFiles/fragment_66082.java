Iterator<Integer> it = s.iterator();
    while(it.hasNext())
    {
        Integer val= it.next();          
        if(val>=0)
        {
            it.remove(); //Use Iterator.remove
            //s.remove(val);
            q.add(val);
        }
    }