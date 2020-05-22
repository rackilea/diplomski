Hashtable<String, String> ht = new Hashtable<String, String>();
    ht.put("key1", "value1");
    ht.put("key2", "value2");
    ht.put("key3", "value3");

    Map<String, String> map = new HashMap<String,String>();

    for (String key : ht.keySet()) {
        map.put(key, ht.get(key));
    }

    for (String key : map.keySet()) {
        System.out.println(key+"\t"+map.get(key));
    }