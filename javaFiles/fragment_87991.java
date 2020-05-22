outerMap.put("1001",new HashMap<String, Integer>());//create separate maps
outerMap.put("1002",new HashMap<String, Integer>());
outerMap.put("1003",new HashMap<String, Integer>());

HashMap<String, Integer> innerMap =outerMap.get("1001");//get the map you want to put value
innerMap.put("1", 1);//assign the value