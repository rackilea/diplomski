// declaring map
Map<String, Integer> playersInArenas = new HashMap<String, Integer>();
playersInArenas.put("A", 5);
playersInArenas.put("B", 4);
playersInArenas.put("C", 5);

// "searching" strings
for (Entry<String, Integer> e : playersInArenas.entrySet()) {
    if (e.getValue() == 5) {
        System.out.println(e.getKey());
    }
}