import static java.lang.System.arraycopy;

public class Test
{
  private final int width = 5, height = 5;
  private int[] pixels = {0,0,1,0,0,
                          0,0,1,0,0,
                          0,0,1,0,0,
                          0,0,1,0,0,
                          0,0,1,0,0};

  public Test rotate(double angle) {
    final double radians = Math.toRadians(angle),
    cos = Math.cos(radians), sin = Math.sin(radians);
    final int[] pixels2 = new int[pixels.length];
    for (int x = 0; x < width; x++)
      for (int y = 0; y < height; y++) {
        final int
          centerx = this.width / 2, centery = this.height / 2,
          m = x - centerx,
          n = y - centery,
          j = ((int) (m * cos + n * sin)) + centerx,
          k = ((int) (n * cos - m * sin)) + centery;
        if (j >= 0 && j < width && k >= 0 && k < this.height)
          pixels2[(y * width + x)] = pixels[(k * width + j)];
      }
    arraycopy(pixels2, 0, pixels, 0, pixels.length);
    return this;
  }
  public Test print() {
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++)
        System.out.print(pixels[width*y + x]);
      System.out.println();
    }
    System.out.println();
    return this;
  }
  public static void main(String[] args) {
    new Test().print().rotate(-45).print();
  }
}