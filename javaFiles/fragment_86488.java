public class InnerClass extends Polygon {
    InnerClass(double x, double y, double side) {
        double mySideSqrt = Math.sqrt((side * side) - (side / 2 * side / 2)) / 2;
        double tX = x;
        double tY = y - mySideSqrt;
        double rX = x + side / 2;
        double rY = y + mySideSqrt;
        double lX = x - side / 2;
        double lY = y + mySideSqrt;

        getPoints().addAll(tX, tY, rX, rY, lX, lY);
    }
}