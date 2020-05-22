Map<String, String> map = new TreeMap<String, String>(); // create TreeMap

map.put("Key1", "Value1"); // insert a node
map.put("Key2", "Value2"); // insert another node

for (Entry<String, String> entry : map.entrySet()) { // iterate over entrySet
    String key = entry.getKey();
    String value = entry.getValue();
    System.out.println(key + ": " + value);
}