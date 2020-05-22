Map<Integer, String> map = new LinkedHashMap<Integer, String>();

map.put(1, "one");
map.put(2, "two");
map.put(3, "three");
map.put(4, "four");
map.put(5, "five");
map.put(6, "six");
map.put(7, "seven");
map.put(8, "eight");
map.put(9, "nine");

int index = 0;
for (Integer key : map.keySet()) {
    if (index++ < 6)
        continue;

    System.out.println(map.get(key));
}

// Prints:
//     seven
//     eight
//     nine