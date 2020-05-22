Iterator<String> iter = events.iterator();
    while(iter.hasNext())
    {
        String item = iter.next();
        if(item.equals(<what>)) {
            iter.remove(); //or split() or whatever.
        }
    }