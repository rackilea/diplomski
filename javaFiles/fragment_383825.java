Map<String,String> map = new LinkedHashMap<>();
map.put("key1", "value1");
map.put("key2", "value2");
map.put("key3", "value3");
String text = map.entrySet().stream()
                 .map(e -> e.getKey() + ":" + e.getValue())
                 .collect(Collectors.joining(","));
System.out.println(text);