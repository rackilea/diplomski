Map<String, String> map1 = new HashMap<String, String>();
map1.put("referrer", "abc.com");

Map<String, String> map2 = new HashMap<String, String>();
map2.put("category", "def.com");

Map<String, String> map3 = new HashMap<String, String>();

map3.putAll(map1);
map3.putAll(map2);

for (Map.Entry<String, String> mapping : map3.entrySet()) {
    System.out.println(mapping.getKey() + " = " + mapping.getValue());
}