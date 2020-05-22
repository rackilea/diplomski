// in your module
install(new PrivateModule() {
  @Override public void configure() {
    SimpleCalculator calculator = new SimpleCalculator(-2);
    bind(ScoreCalculator.class).toInstance(calculator);
    bind(ScoreValidator.class).toInstance(
        new PlainScoreValidator(calculator, PossibleDealResults.fullRange());
    expose(Deal.class).annotatedWith(TakeNothing.class); // custom annotation
  }
});