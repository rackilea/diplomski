HashMap<String, Float[]> mymap = new HashMap<>();
Float[] val = new Float[] { 5f };
mymap.put("hello", val);
mymap.put("bye", val);
...
mymap.get("bye")[0] = mymap.get("bye")[0] + 5f;

mymap.get("hello")[0] == 10f