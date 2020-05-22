Hashtable<Integer, List<Integer>> ht = new Hashtable<>();
for (int i = 0; i < 100; i++) {
  int key = i % 10;
  List<Integer> list = ht.get(key);
  if (list == null) {
    list = new ArrayList<>();
    ht.put(key, list);
  }
  list.add(i);      
}

Enumeration<List<Integer>> eles = ht.elements();
while (eles.hasMoreElements()) {
  System.out.println(Arrays.toString(eles.nextElement().toArray()));
}