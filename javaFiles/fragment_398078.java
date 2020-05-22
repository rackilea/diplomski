public String[] sort(String[] data) {
    TreeMap<String, Integer> sortmap = new TreeMap<String, Integer>();
    ArrayList<String> stringlist = new ArrayList<String>();
    for(String x : data){
        if(sortmap.containsKey(x))
            sortmap.put(x, sortmap.get(x)+1);
        else
            sortmap.put(x, 1);
    }
    Arrays.sort(sortmap.values().toArray(), 0, sortmap.size());
    for (int i = data.length; i > 0; i--){
        for (Entry<String, Integer> k : sortmap.entrySet()){
            if (k.getValue() == i)
                stringlist.add(k.getKey());
        }
    }
    String[] output = stringlist.toArray(new String[stringlist.size()]);
    return output;
}