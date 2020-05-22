Map<String, Integer> firstMap = new HashMap<String, Integer>();

Map<Integer, Map<String, Integer>> finalMap = new HashMap<Integer, Map<String, Integer>>();

firstMap.put("Jason", 2);
finalMap.put(1, firstMap);

// here we create a new instance of that HashMap
firstMap = new HashMap<String, Integer>();

firstMap.put("Jason", 15);
finalMap.put(2, firstMap);
System.out.println(finalMap);