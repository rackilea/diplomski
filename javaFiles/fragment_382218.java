SortedSet<Object> common = new TreeSet<>(sortedSet1);
common.retainAll(sortedSet2);
SortedSet<Object> all = new TreeSet<>(sortedSet1);
all.addAll(sortedSet2);
SortedSet<Object> differences = new TreeSet<>(all);
differences.removeAll(common);