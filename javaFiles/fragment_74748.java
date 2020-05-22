Ordering<NormalTile> myOrdering = Ordering.natural()
  .onResultOf(new Function<Integer,NormalTile>() {
  public Integer call(NormalTile t) {
      return t.getNumber();
  }))
  .nullsLast();
...
Collections.sort(list, myOrdering);
//or
newList = myOrdering.sortedCopy(readonlyList);