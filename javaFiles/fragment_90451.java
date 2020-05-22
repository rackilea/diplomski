public static final class AggregatedAction {
  private final StringBuilder concatenatedAction = new StringBuilder();
  private final String action;
  private final Date firstOccurence;

  public AggregatedAction(Date firstOccurence, String action) {
    this.firstOccurence = firstOccurence;
    this.action = action;
    concatenatedAction.append(action);
  }

  public void append(Date nextOccurence) {
    concatenatedAction.append(" ").append(action).append(" [").append(nextOccurence).append(" ]");
  }
}