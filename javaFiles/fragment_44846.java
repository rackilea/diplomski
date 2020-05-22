public class StylistArray {
  // use a final so the value can't be change once the object is created.
  private final String stylist;
  private final String endTime;

  public StylistArray(String stylist, String endTime) {
    this.stylist = stylist;
    this.endTime = endTime;
  }

  public String getStylist() {
    return stylist;
  }

  public String getEndTime() {
    return endTime;
  }
}