Map<Integer,Object> map_1 = new HashMap<Integer,Object>();
Map<Integer,String> map = new HashMap<Integer,String>();

map.put(1,"suhail");
// The first "map" object gets inserted
map_1.put(20,map);

// Make a new object
map = new HashMap<Integer,String>();

map.put(1,"CSE");
// Now the second object gets inserted
map_1.put(21,map);