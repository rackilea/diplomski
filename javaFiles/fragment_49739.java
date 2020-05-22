// make sure that this is final so we can use it inside of the comparator
final String nameIn = scan.next();
// make a final reference to the names array so that it can be accessed in the comparator
final id[] namesFinal = names;
// this will be the array we will sort, it will hold the sorted indices of
// elements in the names array
final Integer[] sortedIndices = new Integer[names.length];

// initialize the sortedIndices array (index 0 is 0, index 1 is 1, etc)
for (int i = 0; i < sortedIndices.length; i++) {
    sortedIndices[i] = i;
}


Arrays.sort(sortedIndices, 0, names.length, new Comparator<Integer>() {

  @Override
  public int compare(Integer o1, Integer o2) {
    // get the names from the names array using o1 and o2 as indices
    String name1 = namesFinal[o1].name;
    String name2 = namesFinal[o2].name;

    // how different is name1 from nameIn?
    int name1Distance = levenshteinDistance(name1, nameIn);

    // how different is name2 from nameIn?
    int name2Distance = levenshteinDistance(name2, nameIn);

    // difference of the differences
    // if name1 and name2 are equally different from nameIn then this is 0
    // meaning that name1 and name2 are "equal"
    // if name1 is less different than name2 then this will be < 0
    // meaning that name1 is "less than" name2
    // if name1 is more different that name2 then this will be > 0
    // meaning that name1 is "more than" name2
    return name1Distance - name2Distance;
  }
});
// the sortedIndices array is now sorted
// the first element in the array is the index of the name that is least different from nameIn
// the last element in the array is the index of the name that is most different from nameIn