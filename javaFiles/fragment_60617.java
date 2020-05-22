private <T> void genericTestHelperDraft2(Class<T> t, Object current) {
  T currentDowncast = t.cast(current);
  StrategyFactory factory = new StrategyFactory();
  IStrategy<T> createStrategy = factory.createStategy(t);
  createStrategy.doStrategy(currentDowncast);
}