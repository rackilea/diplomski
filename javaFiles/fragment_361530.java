ArrayList<SparseArray<String>> myArray = new ArrayList<>(8000);
for(int i=0; i<8000; i++) {
    SparseArray<String> sp = new SparseArray<>(2);
    sp.put(1, string1);
    sp.put(2, string2);
    myArray.add(sp);
}