Map<String, String> map = new HashMap<String, String>();
map.put("book", null);
map.put("pen", null);

for (String key : map.keySet()) {
    map.put(key, "Some Value");
}

System.out.println(map);