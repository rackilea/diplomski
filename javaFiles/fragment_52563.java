ArrayList<String> list;
if(myHashMap.containsKey(key)){
    // if the key has already been used,
    // we'll just grab the array list and add the value to it
    list = myHashMap.get(key);
    list.add(value);
} else {
    // if the key hasn't been used yet,
    // we'll create a new ArrayList<String> object, add the value
    // and put it in the array list with the new key
    list = new ArrayList<String>();
    list.add(value);
    myHashMap.put(key, list);
}