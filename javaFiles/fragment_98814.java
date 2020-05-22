public class Tools  {
  ...
  public void yourMethod() {
    Session s   = ExtLibUtil.getCurrentSession();
    DateTime dt = s.createDateTime("Today");
    String n    = s.getEffectiveUserName();
    ...
  }
}