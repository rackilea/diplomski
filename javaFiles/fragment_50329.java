int len = strList1.size();
NavigableSet<Integer> sizes = new TreeSet<>();
sizes.addAll(Arrays.asList(1, 5, 10, 50, 100, 200, 1000, len));
for(int size: sizes.lower(len+1)) {
    List<String> list2 = strList1.subList(0, size);
    // process list2
}