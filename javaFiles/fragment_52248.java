return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
    Iterators.mergeSorted(
      Arrays.asList(stream1.iterator(), stream2.iterator()),
      comparator),
    Spliterator.ORDERED),
  false /* not parallel */ );