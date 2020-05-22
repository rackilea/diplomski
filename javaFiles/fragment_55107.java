Map<String, Number> map = new HashMap<String, Number>();

map.put("one", 1);
map.put("two", 2.0);
map.put("three", 1L);

for(String k:map.keySet()) {
  Number v = map.get(k);
  System.err.println(v + " is instance of " + v.getClass().getName() + ": " + v);
}