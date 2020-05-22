Map<Integer, Object> map = new HashMap<>();

// add entry 0 -> 
map.put(0, null);

Object get1 = map.get(0); // returns null, so 0 must be a key in our map!
Object get2 = map.get(1); // also returns null, so is 1 a key too? No!