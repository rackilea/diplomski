public static Integer maxUnduplicatedVal(ArrayList<Integer> lst){
    if(lst == null || lst.isEmpty()) 
        return null;
    if(lst.size() == 1) return lst.get(0);

    if(! lst.get(lst.size() - 1).equals(lst.get(lst.size() - 2))) 
        return lst.get(lst.size() - 1);

    for(int i = lst.size() - 2; i > 0; i--){
        Integer next = lst.get(i + 1);
        Integer here = lst.get(i);
        Integer prev = lst.get(i - 1);
        if(! next.equals(here) && ! prev.equals(here)) return here;
    }

    if(! lst.get(0).equals(lst.get(1))) return lst.get(0);
    return null; //All duplicates
}