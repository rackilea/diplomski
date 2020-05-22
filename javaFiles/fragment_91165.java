private static class CountOddsFn extends DoFn<Integer, Void> {

  Aggregator<Integer, Integer> aggregator =
    createAggregator("odds", new SumIntegerFn());

  @Override
  public void processElement(ProcessContext c) throws Exception {
    if (c.element() % 2 == 1) {
      aggregator.addValue(1);
    }
  }
}