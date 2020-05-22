Set<String> a = new HashSet<>(Arrays.asList("1", "2", "7"));
Set<String> b = new HashSet<>(Arrays.asList("2", "4", "9"));

Set<String> deleteSet = new HashSet<>(a);
deleteSet.removeAll(b);                   // [1, 7]
Set<String> createSet = new HashSet<>(b);
createSet.removeAll(a);                   // [4, 9]