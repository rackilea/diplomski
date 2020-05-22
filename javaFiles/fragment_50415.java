Map<String,String> map = new HashMap<>();
Map<String, String> unmodifiableMap = Collections.unmodifiableMap(map);

map.put("key","value");

for (String key : unmodifiableMap.keySet()) {
   System.out.println(key); // prints key
}