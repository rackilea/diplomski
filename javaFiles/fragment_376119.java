class DealFactoryImpl implements DealFactory {
  @Inject Provider<DefaultScoreCalculator> defaultScoreCalculatorProvider;
  @Inject MultiplierScoreCalculator.Factory multiplerScoreCalculatorFactory;

  @Override public ScoreCalculator getFromDeal(Deal deal) {
    if (TakeNothing.equals(Deal)) {
      return defaultScoreCalculatorProvider.get();
    } else {
      return multiplierScoreCalculatorFactory.create(-2); // assisted inject 
    }
  } /* ... */
}