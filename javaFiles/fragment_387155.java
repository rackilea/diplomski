// using Comparator constructor argument of TreeSet
TreeSet < String > ts = new TreeSet < String > (new Comparator < String > () {

 @Override
 public int compare(String o1, String o2) {
  // reverse sorting logic
  return o2.compareTo(o1);
 }
});

// add HashSet elements to TreeSet
ts.addAll(grandChildren);

System.out.println("\n\n\nAfter Sorting : Descending order\n");

// Iterating using Iterator
Iterator < String > ascSorting = ts.iterator();
while (ascSorting.hasNext()) {
 System.out.println(ascSorting.next());
}