Map<Integer, String> map = new HashMap<Integer, String>();
    //fill in map
    Set<Entry<Integer, String>> set = map.entrySet();

    Map<Integer, String> mapFromSet = new HashMap<Integer, String>();
    for(Entry<Integer, String> entry : set)
    {
        mapFromSet.put(entry.getKey(), entry.getValue());
    }