class Point {
  int x;
  int y;

  Point(int x, int y){
    this.x = x;
    this.y = y;
  }
}

public class Testing {
  Point[] polygon;

  Testing(Point[] polygon) {
    this.polygon = polygon;
  }

  public static void main(final String[] args) {
    Point[] polygon = {new Point(5,11), new Point(4,4), new Point(11,2), new Point(2,2)};
    Testing test = new Testing(polygon);

    Point pOutside = new Point(6,6);
    Point pInside = new Point(3,3);
    System.out.println(test.isInsideByEvenOddRule(pOutside)); // false
    System.out.println(test.isInsideByEvenOddRule(pInside));  // true
  }

  // java implementation of https://en.wikipedia.org/wiki/Even–odd_rule
  boolean isInsideByEvenOddRule(Point point){
    boolean result = false;
    int j = polygon.length - 1;
    for (int i = 0; i < polygon.length; i++) {
        if ((polygon[i].y > point.y) != (polygon[j].y > point.y) &&
                (point.x < polygon[i].x + (polygon[j].x - polygon[i].x) *
                  (point.y - polygon[i].y) / (polygon[j].y - polygon[i].y))) {
          result = !result;
        }
      j = i;
    }
    return result;
  }
}