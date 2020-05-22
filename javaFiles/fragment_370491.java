Tuple<List<U>,List<V>> tupleOfLists = listOfTuples
  .stream()
  .reduce(
    new Tuple<List<U>,List<V>>(new ArrayList<U>(), new ArrayList<V>()),
    (tupleOfLists, tuple) -> {
      tupleOfLists.left().add(tuple.left());          
      tupleOfLists.right().add(tuple.right());
      return tupleOfLists;
    },
    (tupleOfLists1, tupleOfLists2) -> {
      tupleOfLists1.left().addAll(tupleOfLists2.left());
      tupleOfLists1.right().addAll(tupleOfLists2.right());
      return  tupleOfLists1;
    }
  );