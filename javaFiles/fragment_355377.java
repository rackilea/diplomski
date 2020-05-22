for(Map.Entry<HashMap<Integer, Integer>, HashMap<Integer, Integer>> entry : last.entrySet())
{
    HashMap<Integer, Integer> key = entry.getKey();
    for(Map.Entry<Integer, Integer> keyMapEntry : key.entrySet())
    {
        //Loop through the value HashMap. 
        //keyMapEntry.getKey() gives the key of the Hashmap that is the key in the 
        //original Hashmap, keyMapEntry.getValue() gives the value
    }

    HashMap<Integer, Integer> value = entry.getValue();
    for(Map.Entry<Integer, Integer> valueMapEntry : value.entrySet())
    {
        //Loop through the key HashMap
        //valueMapEntry.getKey() gives the key of the Hashmap that is the value in the 
        //original Hashmap, valueMapEntry.getValue() gives the value
    }
}