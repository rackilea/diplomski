Map<Integer, Boolean> map = new ConcurrentHashMap<>();
for (int i = 0; i < 10; i++)
    map.put(i, true);
System.out.println(map.keySet());
List<Integer> ints = new ArrayList<>(map.keySet());
Map<Integer, Boolean> map2 = new ConcurrentHashMap<>();
for (int i = 0; i < 10; i += 2)
    map2.put(ints.get(i), false);
System.out.println("All evens " + map2.keySet());
// all evens
Iterator<Integer> iter = map2.keySet().iterator();
for (int i = 8; i >= 0; i -= 2) {
    // remove evens and add odds
    map2.remove(ints.get(8 - i));
    map2.remove(ints.get(i));
    map2.put(ints.get(i + 1), false);
    System.out.println(iter.next() +" - full set is: "+map2.keySet());
}
while (iter.hasNext())
    System.out.println(iter.next());
System.out.println("All odds " + map2.keySet());