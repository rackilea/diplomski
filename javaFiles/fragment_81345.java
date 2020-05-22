final NavigableMap<Integer, String> map = new TreeMap<Integer, String>();
map.put(0, "Cry Baby");
map.put(6, "School Time");
map.put(16, "Got a car yet?");
map.put(21, "Tequila anyone?");
map.put(45, "Time to buy a corvette");

System.out.println(map.floorEntry(3).getValue());
System.out.println(map.floorEntry(10).getValue());
System.out.println(map.floorEntry(18).getValue());