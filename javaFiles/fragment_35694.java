// The test map
final Map<String, String> map = new HashMap<String, String>();
map.put("Key1", "Value");
map.put("Key2", "Value");
map.put("Key3", "Value");

// Remove the map. The collection is necessary to remove all values instead of just one.
map.values().removeAll(Collections.singleton("Value"));

// Print the map to confirm it worked.
System.out.println("Printing Map");
for(final String key : map.keySet()) {
   System.out.println(key + " = " + map.get(key));
}