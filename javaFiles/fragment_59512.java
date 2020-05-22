public Map<Key, List<Value>> concat(Map<Key, Value> first, Map<Key, Value> second){
    Map<Key, List<Value>> concat = new HashMap<Key, List<Value>>();
    putMulti(first, concat);
    putMulti(second, concat);
    return concat;
}

private void putMulti(Map<Key, Value> content, Map<Key, List<Value>> dest){
    for(Map.Entry<Key, Value> entry : content){
        List<Value> vals = dest.get(entry.getKey());
        if(vals == null){
            vals = new ArrayList<Value>();
            dest.put(entry.getKey(), vals);
        }
        vals.add(entry.getValue());
    }
}