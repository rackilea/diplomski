BiMap<Integer, String> biMap = HashBiMap.create();
biMap.put(1, "foo");
biMap.put(21, "bar");

System.out.println(biMap.get("1"))); //foo
System.out.println(biMap.inverse().get("bar"))); //21