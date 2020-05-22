import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;

class Line {
    public Point offset;
    public double angle;

    public Line(Point offset, double angle) {
        this.offset = offset.clone();
        this.angle = angle;
    }

    public Point get(int length) {
        Point result = offset.clone();
        result.x += Math.cos(angle) * length;
        result.y += Math.sin(angle) * length;
        return result;
    }

    public Point getStart() {
        return get(-5000);
    }

    public Point getEnd() {
        return get(5000);
    }

    public void scale(double factor) {
        offset.x *= factor;
        offset.y *= factor;
    }

    public static Point intersect(Line l1, Line l2) {
        return getLineLineIntersection(l1.getStart().x, l1.getStart().y, l1.getEnd().x, l1.getEnd().y,
                l2.getStart().x, l2.getStart().y, l2.getEnd().x, l2.getEnd().y
                );
    }

    public static Point getLineLineIntersection(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
      double det1And2 = det(x1, y1, x2, y2);
      double det3And4 = det(x3, y3, x4, y4);
      double x1LessX2 = x1 - x2;
      double y1LessY2 = y1 - y2;
      double x3LessX4 = x3 - x4;
      double y3LessY4 = y3 - y4;
      double det1Less2And3Less4 = det(x1LessX2, y1LessY2, x3LessX4, y3LessY4);
      if (det1Less2And3Less4 == 0){
         // the denominator is zero so the lines are parallel and there's either no solution (or multiple solutions if the lines overlap) so return null.
         return null;
      }
      double x = (det(det1And2, x1LessX2,
            det3And4, x3LessX4) /
            det1Less2And3Less4);
      double y = (det(det1And2, y1LessY2,
            det3And4, y3LessY4) /
            det1Less2And3Less4);
      return new Point(x, y);
   }
   protected static double det(double a, double b, double c, double d) {
      return a * d - b * c;
   }
}

class LineSegment extends Line implements Comparable {
    public double length;

    public LineSegment(Point offset, double angle, double length) {
        super(offset, angle);
        this.length = length;
    }

    public void melt(LineSegment segment) {
        Point point = new Point();
        point.x += Math.cos(angle) * length;
        point.y += Math.sin(angle) * length;
        point.x += Math.cos(segment.angle) * segment.length;
        point.y += Math.sin(segment.angle) * segment.length;

        angle = Math.atan2(point.y, point.x);
        offset.x = (offset.x * length + segment.offset.x * segment.length) / (length + segment.length);
        offset.y = (offset.y * length + segment.offset.y * segment.length) / (length + segment.length);

        length += segment.length;
    }

    @Override
    public int compareTo(Object other) throws ClassCastException {
        if (!(other instanceof LineSegment)) {
            throw new ClassCastException("A LineSegment object expected.");
        }
        return (int) (((LineSegment) other).length - this.length);    
    }
}

class Quadrangle {
    static int
        TOP = 0,
        RIGHT = 1,
        BOTTOM = 2,
        LEFT = 3;

    public Line[] lines = new Line[4];

    public Quadrangle() {

    }

    private static double getAngle(Point p1, Point p2) {
        return Math.atan2(p2.y - p1.y, p2.x - p1.x);
    }

    private static double getLength(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }

    private static double roundAngle(double angle) {
        return angle - (2*Math.PI) * Math.round(angle / (2 * Math.PI));
    }

    public static Quadrangle fromContour(MatOfPoint contour) {
        List<Point> points = contour.toList();
        List<LineSegment> segments = new ArrayList<>(); 

        // Create line segments
        for (int i = 0; i < points.size(); i++) {
            double a = getAngle(points.get(i), points.get((i + 1) % points.size())); 
            double l = getLength(points.get(i), points.get((i + 1) % points.size())); 
            segments.add(new LineSegment(points.get(i), a, l));
        }

        // Connect line segments
        double angleDiffMax = 2 * Math.PI / 100;
        List<LineSegment> output = new ArrayList<>();
        for (LineSegment segment : segments) {
            if (output.isEmpty()) {
                output.add(segment);
            } else {
                LineSegment top = output.get(output.size() - 1);
                double d = roundAngle(segment.angle - top.angle);
                if (Math.abs(d) < angleDiffMax) {
                    top.melt(segment);
                } else {
                    output.add(segment);
                }
            }
        }

        Collections.sort(output);

        Quadrangle quad = new Quadrangle();

        for (int o = 0; o < 4; o += 1) {
            for (int i = 0; i < 4; i++) {
                if (Math.abs(roundAngle(output.get(i).angle - (2 * Math.PI * o / 4))) < Math.PI / 4) {
                    quad.lines[o] = output.get(i);
                }
            }
        }

        return quad;
    }

    public void scale(double factor) {
        for (int i = 0; i < 4; i++) {
            lines[i].scale(factor);
        }
    }

    public Mat warp(Mat src) {
        Mat result = src.clone();


        Core.line(result, lines[TOP].get(-5000), lines[TOP].get(5000), new Scalar(200, 100, 100), 8);
        Core.line(result, lines[RIGHT].get(-5000), lines[RIGHT].get(5000), new Scalar(0, 255, 0), 8);


        Core.line(result, lines[BOTTOM].get(-5000), lines[BOTTOM].get(5000), new Scalar(255, 0, 0), 8);
        Core.line(result, lines[LEFT].get(-5000), lines[LEFT].get(5000), new Scalar(0, 0, 255), 8);



        Point p = Line.intersect(lines[TOP], lines[LEFT]);
        System.out.println(p);
        if (p != null) {
            Core.circle(result, p, 30, new Scalar(0, 0, 255), 8);
        }

        double width = 1400;
        double height = width / 2.15;

        Point[] srcProjection = new Point[4], dstProjection = new Point[4];
        srcProjection[0] = Line.intersect(lines[TOP], lines[LEFT]);
        srcProjection[1] = Line.intersect(lines[TOP], lines[RIGHT]);
        srcProjection[2] = Line.intersect(lines[BOTTOM], lines[LEFT]);
        srcProjection[3] = Line.intersect(lines[BOTTOM], lines[RIGHT]);

        dstProjection[0] = new Point(0, 0);
        dstProjection[1] = new Point(width - 1, 0);
        dstProjection[2] = new Point(0, height - 1);
        dstProjection[3] = new Point(width - 1, height - 1); 


        Mat warp = Imgproc.getPerspectiveTransform(new MatOfPoint2f(srcProjection), new MatOfPoint2f(dstProjection));
        Mat rotated = new Mat();
        Size size = new Size(width, height);
        Imgproc.warpPerspective(src, rotated, warp, size, Imgproc.INTER_LINEAR);
        return rotated;
    }
}