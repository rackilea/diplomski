final Map<String, Object> map = new HashMap<String, Object>();
final List<String> nested = Arrays.asList("foo", "bar", "baz");

map.put("given", "Arthur");
map.put("family", "Dent");
map.put("nested", nested);

System.out.println(map);