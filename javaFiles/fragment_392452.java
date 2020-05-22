/**
   * Returns a collector that collects to a pair list.
   * 
   * @return the collector
   */
  public static <E> Collector<E, ?, PairList<E>> toPairList() {
    return Collectors.collectingAndThen(Collectors.toList(), PairList::new);
  }