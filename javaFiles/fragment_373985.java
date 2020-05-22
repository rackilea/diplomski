public class ClosestPoint {
    public static void main(String[] args) {
        final int X = 0;
        final int Y = 1;

        // input coordinates to search against
        double[] coordinate = {37.423423, -122.083953};

        // input points to search against
        double[][] points = {{37.00, -121.50},  // 0  A1
                {37.00, -122.00},  // 1  A2
                {37.00, -122.50},  // 2  A3
                {37.50, -121.50},  // 3  B1
                {37.50, -122.00},  // 4  B2
                {37.50, -122.50},  // 5  B3
                {38.00, -121.50},  // 6  C1
                {38.00, -122.00},  // 7  C2
                {38.00, -122.50}   // 8  C3
        };

        String[] zonenames = {
                        "A1",
                        "A2",
                        "A3",
                        "B1",
                        "B2",
                        "B3",
                        "C1",
                        "C2",
                        "C3",
        };

        //double[] closest = nearestPoint(coordinate, points);
        int index = nearestPoint(coordinate, points);
        double[] closest =  points[index];
        String zone = zonenames[index];

        System.out.println("("+closest[X]+", "+closest[Y]+")");
        System.out.println("Zone: " + zone);
        double d = distance(coordinate[X], coordinate[Y], closest[X], closest[Y]);
        System.out.println("Distance: "+ d);
    }

    public static double distance(double x1, double y1, double x2, double y2) {
        double x = Math.pow(x2 - x1, 2);
        double y = Math.pow(y2 - y1, 2);
        return Math.sqrt( x + y );
    }

    //public static double[] nearestPoint(double[] coordinate, double[][] points) {
    public static int nearestPoint(double[] coordinate, double[][] points) {
        final int X = 0;
        final int Y = 1;
        int indexFound = 0;
        double[] closestPoint = points[0];
        double closestDist = distance(coordinate[X], coordinate[Y],
                closestPoint[X], closestPoint[Y]);

        // Traverse the array
        for(int i = 0; i < points.length; i++) {
            double dist = distance(coordinate[X], coordinate[Y],
                    points[i][X], points[i][Y]);
            if (dist < closestDist && dist != 0.0) {
                closestDist = dist;
                closestPoint = points[i];
                indexFound = i;
            }
        }

        //return closestPoint;
        return indexFound;
    }
}