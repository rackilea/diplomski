import java.util.HashSet;
import java.util.Set;

public class Main {
    public static Set<Point> pointsSet = new HashSet<>();

    public static void main(String[] args) {
        //Suppose, that points are already parsed from file
        Point[] points = new Point[]{
                new Point(-1, -1),
                new Point(2, 1),
                new Point(4, -2),
                new Point(1, -4)
        };

        //Fill hashset with points. Important: hashCode() and equals() methods are overrided in Point class
        for (Point point : points) {
            pointsSet.add(point);
        }

        Point point1;
        Point point2;
        Point suggested_point3;
        Point suggested_point4;

        //Consider every pair of points
        for (int i = 0; i < points.length - 1; i++) {
            point1 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                point2 = points[j];

                //Calculate vector coordinates for pair of points
                Vector vector = new Vector(point2.getX() - point1.getX(), point2.getY() - point1.getY());

                //Rotate vector clockwise by 90 degrees and calculate coordinates,
                //where two more points should be to form a square with current pair of points
                Vector clockwise_rotated_vector = rotateVector(vector, 90);
                suggested_point3 = moveVectorToPoint(clockwise_rotated_vector, point1);
                suggested_point4 = moveVectorToPoint(clockwise_rotated_vector, point2);
                if (pointsSet.contains(suggested_point3) && pointsSet.contains(suggested_point4)) {
                    squareFound(point1, point2, suggested_point3, suggested_point4);
                }

                //Same for counterclockwise rotated vector
                Vector counterclockwise_rotated_vector = rotateVector(vector, -90);
                suggested_point3 = moveVectorToPoint(counterclockwise_rotated_vector, point1);
                suggested_point4 = moveVectorToPoint(counterclockwise_rotated_vector, point2);
                if (pointsSet.contains(suggested_point3) && pointsSet.contains(suggested_point4)) {
                    squareFound(point1, point2, suggested_point3, suggested_point4);
                }
            }
        }
    }

    private static void squareFound(Point point1, Point point2, Point point3, Point point4) {
        System.out.println(String.format("%s, %s, %s, %s", point1, point2, point3, point4));
    }

    private static Point moveVectorToPoint(Vector vector, Point point) {
        double x = point.getX() + vector.getX();
        double y = point.getY() + vector.getY();
        return new Point(x, y);
    }

    private static Vector rotateVector(Vector original_vector, double degrees) {
        double radians = Math.toRadians(degrees);
        double x = original_vector.getX() * Math.cos(radians) - original_vector.getY() * Math.sin(radians);
        double y = original_vector.getX() * Math.sin(radians) + original_vector.getY() * Math.cos(radians);
        return new Vector(x, y);
    }
}