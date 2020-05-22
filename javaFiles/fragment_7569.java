import static java.lang.Double.compare;
import static java.lang.Double.isFinite;
import static java.lang.Math.PI;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.DoubleUnaryOperator;
import static java.util.stream.Collectors.toList;
import java.util.stream.DoubleStream;

public class AdaptivePlot {
  private final DoubleUnaryOperator f;
  private final double a;
  private final double c;
  private final SortedSet<Point> plot = new TreeSet<>((s, t) -> compare(s.x, t.x));

  public AdaptivePlot(DoubleUnaryOperator f, double a, double c) {
    this.f = f;
    this.a = a;
    this.c = c;
  }

  public static class Point {
    final double x, y;
    public Point(double x, double y) {
      this.x = x;
      this.y = y;
    }
  }

  public AdaptivePlot computePlot(int depth, double eps) {
    plot.clear();
    Point pa = pointAt(a);
    Point pc = pointAt(c);
    plot.add(pa);
    plot.add(pc);
    computePlot(pa, pc, depth, eps);
    return this;
  }

  public List<Point> getPlot() {
    return plot.stream().collect(toList());
  }

  private Point pointAt(double x) {
    return new Point(x, f.applyAsDouble(x));
  }

  private void computePlot(Point pa, Point pc, int depth, double eps) {
    Point pb = pointAt(0.5 * (pa.x + pc.x));
    Point pa1 = pointAt(0.5 * (pa.x + pb.x));
    Point pb1 = pointAt(0.5 * (pb.x + pc.x));
    plot.add(pb);
    if (depth > 0 && 
        (oscillates(pa.y, pa1.y, pb.y, pb1.y, pc.y) 
            || unsmooth(pa.y, pa1.y, pb.y, pb1.y, pc.y, eps))) {
      computePlot(pa, pb, depth - 1, 2 * eps);
      computePlot(pb, pc, depth - 1, 2 * eps);
    }
    plot.add(pa1);
    plot.add(pb1);
  }

  private static boolean oscillates(
      double ya, double ya1, double yb, double yb1, double yc) {
    return isOscillation(ya, ya1, yb) 
        && isOscillation(ya1, yb, yb1) 
        && isOscillation(yb, yb1, yc);
  }

  private static boolean isOscillation(double ya, double yb, double yc) {
    return !isFinite(ya) || !isFinite(yb) || !isFinite(yc) 
        || (yb > ya && yb > yc) || (yb < ya && yb < yc);
  }

  private static boolean unsmooth(
      double ya, double ya1, double yb, double yb1,double yc, double eps) {
    double y0 = DoubleStream.of(ya, ya1, yb, yb1, yc).min().getAsDouble();
    double [] yg = DoubleStream.of(ya, ya1, yb, yb1, yc).map(y -> y - y0).toArray();
    double q4 = quadrature(yg[0], yg[1], yg[2], yg[3]);
    double q3 = quadrature(yg[2], yg[3], yg[4]);
    return Math.abs(q4 - q3) > eps * q3;
  }

  private static double quadrature(double y0, double y1, double y2, double y3) {
    return 3d/8d * y0 + 19d/24d * y1 - 5d/24d * y2 + 1d/24d * y3;
  }

  private static double quadrature(double y0, double y1, double y2) {
    return 5d/12d * y0 + 2d/3d * y1 - 1d/12d * y2;
  }

  public static void main(String [] args) {
    List<Point> plot = new AdaptivePlot(x -> x * Math.sin(x), -2d * PI, 2d * PI)
        .computePlot(6, 0.005).getPlot();
    for (Point p : plot) {
      System.out.println(p.x + "\t" + p.y);
    }
  }
}