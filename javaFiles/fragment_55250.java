HashMap<String, HashMap<String, String>> mapofmaps = new HashMap<>();

    HashMap<String,String> map1 = new HashMap<>();
    map1.put("map1_key1", "map1_value1");

    HashMap<String,String> map2 = new HashMap<>();
    map2.put("map2_key1", "map2_value1");

    mapofmaps.put("map1", map1);
    mapofmaps.put("map2", map2);