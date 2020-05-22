public class Test {

  public static void main(String[] args) {

    Point pt1 = new Point();
    Point pt2 = new Point();
  }
}

class Point {
  private static int nb = 0;

  public Point() {
    System.out.println("Object number : " + (++nb));
  }
}