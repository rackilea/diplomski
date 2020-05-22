// in your module adjacent to configure()
@Provides @TakeNothing Deal anyMethodNameWorks(/* dependencies here */) {
  SimpleCalculator calculator = new SimpleCalculator(-2);
  ScoreValidator validator = new PlainScoreValidator(calculator,
      PossibleDealResults.fullRange());
  return new Deal(calculator, validator);
}