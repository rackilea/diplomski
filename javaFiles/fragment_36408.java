public class GetGps {
  private Criteria criteria = new Criteria();

  public GetGps() {
    criteria.setHorizontalAccuracy(5000);
  }
}