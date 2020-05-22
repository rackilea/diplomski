private static List<Integer> getUniques(List<Integer> list) {
    HashMap<Integer, Boolean> flagMap = new HashMap<>();

    //Total Loop: O(N)
    for(Integer i : list){
        if(flagMap.containsKey(i)) flagMap.put(i, false); //O(1)
        else flagMap.put(i, true); //O(1)
    }

    ArrayList<Integer> result = new ArrayList<Integer>();

    //Total Loop: O(N)
    for(Integer i : list){
        if(flagMap.get(i)) result.add(i); //O(1)
    }
    return result;
}

public static Integer maxUnduplicatedVal(ArrayList<Integer> lst){
    List<Integer> lstCopy = getUniques(lst);
    return Collections.max(lstCopy);
}