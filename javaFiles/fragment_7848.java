private static Set<Integer> checkDuplicate(int[] intArray) {
    HashMap<Integer,Integer> values = new HashMap<Integer,Integer>();
    Set<Integer> values2 = new HashSet<Integer>();


    for(Integer i : intArray) //0(n)
    {
        if(values.get(i) != null) //O(1)
            values2.add(i);
        else
            values.put(i, i);
    }


    return values2;
}