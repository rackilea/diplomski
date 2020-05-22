final Map<String, Integer> map = new HashMap<String, Integer>();
map.put("A", 5);
map.put("B", 3);
map.put("C", 10);
map.put("D", 4);
map.put("E", 1);
map.put("F", 11);
map.put("G", 11);
map.put("H", 10);

TreeMap<String, Integer> sorted = new TreeMap<String, Integer>(new Comparator<String>() {
  // Note: this comparator imposes orderings that are inconsistent with equals.
  @Override
  public int compare(String a, String b) {
    if (map.get(a) >= map.get(b)) {
      return -1;
    } else {
      return 1;
    } // returning 0 would merge keys
  }
});
sorted.putAll(map);


Entry<String, Integer> first = sorted.firstEntry();
System.out.println("Highest value: " + first.getValue() + is for key: " + first.getKey());

// If duplicate keys are never a concern, you can stop here.  Otherwise, one may 
// continue below to find all keys that may be mapped to an equal highest value:
List<String> others = new LinkedList<String>();
for (Entry<String, Integer> entries : sorted.entrySet()) {
  if (entries.getValue().equals(first.getValue())) {
    others.add(entries.getKey());
  } else {
    break;
  }
}

System.out.println("All keys mapped to this highest value: " + others);