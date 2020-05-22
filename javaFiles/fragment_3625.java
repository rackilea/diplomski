public class UsesB {
  private B b; // can call A's methods on this field

  public void setObject(B b) {
    this.b = b;
  }
}