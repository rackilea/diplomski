public class BlackjackPlayer implements Player {
  private final PointCalculator pointsCalculator;
  private final String name;
  private final boolean isDealer;
  @AssistedInject BlackjackPlayer(PointCalculator pointsCalculator, @Assisted String name) {
    this.pointsCalculator = pointsCalculator;
    this.name = name;
    this.isDealer = false;
  }
  @AssistedInject BlackjackPlayer(PointCalculator pointsCalculator, @Assisted String name, @Assisted boolean isDealer) {
    this.pointsCalculator = pointsCalculator;
    this.name = name;
    this.isDealer = isDealer;
  }
}