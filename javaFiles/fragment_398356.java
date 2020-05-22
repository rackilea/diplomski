public class MyPoint {

/**
* @param args the command line arguments
*/
public static void main(String[] args) {
  System.out.println(new Point(10D, 10D).distance(new Point(10D,30.5D)));
}

static class Point
{
 private final double x;
 private final double y;

 public Point(double x, double y) {
  this.x=0;
  this.y=0;
 }

 public double getX() { return(this.x); }
 public double getY() { return(this.y); }

 public double distance(Point that) {
    return( this.distance(that.getX(), that.getY() ) );
 }

 public double distance(double x2, double y2) {
 return Math.sqrt((Math.pow((this.x - x2), 2) +Math.pow((this.y-        y2),     2)));

  }       
}
}