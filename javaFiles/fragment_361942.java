public String duplicate(int[] numbers) {

  // holds the items we've encountered more than once.
  // TreeSet<> keeps things in sorted order for us.
  final SortedSet<Integer> duplicates = new TreeSet<>();

  // keeps track of items we've encountered.
  final Set<Integer> encountered = new HashSet<>(); 

  // iterate over every number
  for (final int number : numbers) {
    // Add the item to encountered. Set.add() will return true if 
    // the element is new to the set.
    if (!encountered.add(number)) {
       // Since the element wasn't new, ensure this item exists in the duplicates collection.
       duplicates.add(number);
    }
  }

  return duplicates.toString();
}