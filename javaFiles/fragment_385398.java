public class Vector {
    private final double x;
    private final double y;

    public Vector(double xIn, double yIn) {
        x = xIn;
        y = yIn;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return Math.sqrt((x * x) + (y * y));
    }

    public double getTheta() {
        return flippedAtan2(y, x);
    }

    public double bearingTo(Vector target) {
        return flippedAtan2(target.getY() - y, target.getX() - x);
    }

    public static Vector fromPolar(double magnitude, double angle) {
        double flippedAngle = flipAngle(angle);
        return new Vector(magnitude * Math.cos(flippedAngle),
                magnitude * Math.sin(flippedAngle));
    }

    // flip the angle between 0 is the East + counter-clockwise and 0 is the North + clockwise
    // and vice versa
    private static double flipAngle(double angle) {
        return Math.PI / 2 - angle;
    }

    private static double flippedAtan2(double y, double x) {
        double angle = Math.atan2(y, x);
        double flippedAngle = flipAngle(angle);
        //  additionally put the angle into [0; 2*Pi) range from its [-pi; +pi] range
        return (flippedAngle >= 0) ? flippedAngle : flippedAngle + 2 * Math.PI;
    }
}