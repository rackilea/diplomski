public class MonitoredData {
  private final String activityLabel;
  private final LocalDateTime start;
  private final LocalDateTime end;
  private final long seconds;

  public MonitoredData(LocalDateTime start, LocalDateTime end, String activityLabel) {
    this.start = start;
    this.end = end;
    this.activityLabel = activityLabel;
    this.seconds = ChronoUnit.SECONDS.between(start.toLocalTime(), end.toLocalTime());
  }

  public String getActivityLabel() {
    return activityLabel;
  }

  //other getters
}