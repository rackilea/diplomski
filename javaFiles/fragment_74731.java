Map<Long, String> map = new LinkedHashMap<Long, String>();

map.put(1L, "A");
map.put(2L, "B");
map.put(3L, "C");
map.put(4L, "D");
map.put(5L, "E");

final Iterator<Long> cursor = map.keySet().iterator();
while (cursor.hasNext()) {
    final Long key = cursor.next();          
    final String value = map.get(key);
    System.out.println(key + "\t" + value);
}