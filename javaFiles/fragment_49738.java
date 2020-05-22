// make sure that this is final so we can use it inside of the comparator
final String nameIn = scan.next();
Arrays.sort(names, 0, names.length, new Comparator<id>() {

  @Override
  public int compare(id o1, id o2) {
    String name1 = o1.name;
    String name2 = o2.name;

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
// the names array is now sorted
// the first element in the array is least different from nameIn
// the last element in the array is most different from nameIn