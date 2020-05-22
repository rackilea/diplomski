static List<LinkedList<String>> filterSublistAlternate(LinkedList<LinkedList<String>> l) {
boolean[] removed = new boolean[ l.size() ]; 
outer: for(int i=0; i< l.size() ; i++)
    inner: for(int j=0; j< l.size() ; j++)
    {
        if( i != j )
        if(l.get(j).containsAll(l.get(i)))
        {
            System.out.println(i+" and "+j);
            if(l.get(i).size() == l.get(j).size())
                if(removed[i] == removed[j] && !removed[i])
                    removed[i] = true;
                else
                    continue outer;
            else
            {
                removed[i] = true;
                continue outer;
            }

        }
    }

for(int i=removed.length-1; i>=0  ; i--)
    if(removed[i])
        l.remove(i);

return l;
}