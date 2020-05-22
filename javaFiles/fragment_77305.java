public static void main (String[] args) {
    //a map with key type : String, value type : String
    Map<String,String> mp = new HashMap<String,String>();
    mp.put("John","Math");    mp.put("Jack","Math");    map.put("Jeff","History");

    //3 differents ways to iterate over the map
    for (String key : mp.keySet()){
        //iterate over keys
        System.out.println(key+" "+mp.get(key));
    }

    for (String value : mp.values()){
        //iterate over values
        System.out.println(value);
    }

    for (Entry<String,String> pair : mp.entrySet()){
        //iterate over the pairs
        System.out.println(pair.getKey()+" "+pair.getValue());
    }
}