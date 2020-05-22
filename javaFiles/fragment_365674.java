public static class Point {
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  private int x;
  private int y;

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public String toString() {
    return "(" + String.valueOf(x) + ", "
        + String.valueOf(y) + ")";
  }

  public static Point[] fromString(String in) {
    if (in == null) {
      return null;
    }
    List<Point> al = new ArrayList<Point>();
    int p = 0;
    for (;;) {
      int openPos = in.indexOf('(', p);
      if (openPos > -1) {
        int closePos = in.indexOf(')', openPos + 1);
        if (closePos > -1) {
          String str = in.substring(openPos + 1,
              closePos);
          String[] t = str.split(",");
          p = closePos + 1;
          if (t.length != 2) {
            continue;
          }
          al.add(new Point(Integer.valueOf(t[0]
              .trim()), Integer.valueOf(t[1].trim())));
        } else {
          break;
        }
      } else {
        break;
      }
    }
    return al.toArray(new Point[al.size()]);
  }
}

public static void main(String[] args) {
  Point[] pts = Point
      .fromString("(100,200) (300,600)");
  System.out.println(Arrays.toString(pts));
}