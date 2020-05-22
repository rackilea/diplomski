TreeMap<Integer, String> map = new TreeMap<Integer, String>();

map.put(5, "five");
map.put(6, "six");
map.put(7, "seven");
map.put(8, "eight");
map.put(9, "nine");

for (Integer key : map.tailMap(6).keySet())
    System.out.println(map.get(key));

// Prints
//     six
//     seven
//     eight
//     nine