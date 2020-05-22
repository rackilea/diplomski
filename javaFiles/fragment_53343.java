BidiMap<String, String> map = new DualHashBidiMap<>();
map.put(1, "foo");
map.put(21, "bar");
System.out.println(map.get(1)); //1

//reversing the mapping 
BidiMap<String, String> reversedMap = map.inverseBidiMap();
System.out.println(reversedMap.get("foo")); //1