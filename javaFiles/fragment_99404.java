public void insert(Entry e) 
{
    int i = 0;
    for (i = 0; i < list.size(); i++)       // HERE #1
    {
        if(list.get(i).compareTo(e) > 0  )  // HERE #2
        {
            list.add(i,e);                  // HERE #3
            return;
        }
    }
    list.add(e);                            // HERE #4   
}