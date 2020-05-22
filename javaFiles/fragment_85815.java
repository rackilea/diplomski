Map<Byte, Integer> counters = new HashMap<>();
Path path = FileSystems.getDefault().getPath(args[0]);

// build a map with byte value as a key refering to a counter in the value
for (Byte b: Files.readAllBytes(path)) {
  Integer old = counters.get(b);
  counters.put(b, (old == null ? 1 : old + 1));
}

// create a comparator that orders Map.Entry objects by their value. I.E. the 
// occurences of the respective byte. The order is ascending.
Comparator<Entry<Byte, Integer>> byVal = Comparator.comparingInt(e -> e.getValue());

// create a stream of Map.Entry objects. The stream is a new concept of Java8. 
// That's somehow like a collection, but more powerful. While the collection
// stores data he stream has a focus on manipulating
counters.entrySet().stream()
      // Use the comaparator in reversed form. That means the number of
      // occurences is now descending
      .sorted(byVal.reversed())
      // only use the first Map.Entry. I.E. the one with most occurences
      // a similar functionality is by filter. 
      // .filter(e -> e.getValue() > 1) would use all duplicates
      .limit(1)
      // print out the results. Of course the argument for println can be 
      // concatenated from several parts like: 
      // e.getKey() +  "\tcount: " + e.getValue()
      .forEach(e -> System.out.println(e.getKey()));