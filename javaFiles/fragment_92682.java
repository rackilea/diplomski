public class MyColor {
  private final int red, green, blue;

  private MyColor(int red, int green, int blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  public static MyColor getInstance(int red, int green, int blue) {
    // if combo already exists, return it, otherwise create new instance
  }
}