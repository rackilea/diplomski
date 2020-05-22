import java.math.BigDecimal;
import java.util.Locale;

public class Point {
    public Point(double x, double y) {
        this.x = x;
        this.y = y;

        //Store decimal values with certain scale, which would later be used for hashCode() calculation
        this.decimalX = new BigDecimal(x).setScale(DECIMAL_SCALE, BigDecimal.ROUND_HALF_EVEN);
        this.decimalY = new BigDecimal(y).setScale(DECIMAL_SCALE, BigDecimal.ROUND_HALF_EVEN);
    }

    private static final int DECIMAL_SCALE = 3;

    private double x;
    public double getX() {
        return x;
    }

    private double y;
    public double getY() {
        return y;
    }

    private BigDecimal decimalX;
    private BigDecimal decimalY;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (!decimalX.equals(point.decimalX)) return false;
        return decimalY.equals(point.decimalY);
    }

    @Override
    public int hashCode() {
        //calculate for decimal values, so two very close enough points will have equal hash codes
        int result = decimalX.hashCode();
        result = 31 * result + decimalY.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "(%2f,%2f)", x, y);
    }
}