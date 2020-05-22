int len = strList1.size();
for(int size: new int[] { 1, 5, 10, 50, 100, 200, 1000, len }) {
    if(size > len) continue;
    List<String> list2 = strList1.subList(0, size);
    // process list2
}