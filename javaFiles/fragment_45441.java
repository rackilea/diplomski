Map<String, List<String>> tempMap = new HashMap<String, List<String>>();
tempMap.put("1", new LinkedList<String>());
tempMap.get("1").add("X");
tempMap.get("1").add("Y");
tempMap.get("1").add("Z");

for(String value : tempMap.get("1")) {
  //do something
}