myList.sort(Comparator.comparing(Foo::getDate)
                      .thenComparing(foo-> {
  int index = nameSortingList.indexOf(foo.getName());
  return i == -1 ? // If not found, it should be sorted as trailing instead of leading name
    Integer.MAX_VALUE
   : // Otherwise, sort it on the index in the nameSortingList:
    i;} ));