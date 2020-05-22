public class Vector2 {

  public static final Vector2 ZERO = new Vector2(0, 0);

  private final int x;
  private final int y;

  public Vector2(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Vector2 add(Vector2 v) {
    return new Vector2(this.x + v.x, this.y +v.y);
  }
}