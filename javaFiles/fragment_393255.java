public interface Item {
  public void drawAt(final int x, final int y);
}

public class CircleAround implements Item {
  private final Item wrapped;
  private final int radius;

  public CircleAround(public final Item wrapped, public final int radius) {
    this.wrapped = wrapped;
    this.radius = radius;
  }

  public void drawAt(final int x, final int y) {
    // First handle whatever we are wrapping
    wrapped.drawAt(x,y);
    // Then add our circle
    Graphics.drawCircle(x, y, radius);
  }

}