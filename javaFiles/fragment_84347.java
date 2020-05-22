public class Holder <T> {
  private T held = null;

  public Holder () {
  }

  public Holder (T it) {
    held = it;
  }

  public void hold(T it) {
    held = it;
  }

  public T held() {
    return held;
  }

  @Override
  public String toString () {
    return held == null ? "null": held.toString();
  }
}