import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.PathIterator;
import java.util.Arrays;

/** @see http://stackoverflow.com/questions/5877646 */
public class MyPoly extends Polygon {

    public static void main(String[] args) {
        final MyPoly square = new MyPoly();
        square.addPoint(0, 0);
        square.addPoint(0, 10);
        square.addPoint(10, 10);
        square.addPoint(10, 0);
        System.out.println(square.toString());
        MyPoly pentagon = square.insert(1, new Point(1, 5));
        System.out.println(pentagon.toString());
    }

    /**
     * Insert a point at the specified index
     *  
     * @param index at which to insert the new point
     * @param point the <code>Point</code> to insert
     * @return a new <code>Polygon</code> with the new <code>Point</code> 
     */
    public MyPoly insert(int index, Point point) {
        MyPoly mp = new MyPoly();
        PathIterator pi = this.getPathIterator(null);
        double[] coords = new double[6];
        int i = 0;
        while (!pi.isDone()) {
            if (i == index) {
                mp.addPoint(point.x, point.y);
            } else {
                if (pi.currentSegment(coords) != PathIterator.SEG_CLOSE) {
                    mp.addPoint((int) coords[0], (int) coords[1]);
                }
                pi.next();
            }
            i++;
        }
        return mp;
    }

    @Override
    public String toString() {
        PathIterator pi = this.getPathIterator(null);
        double[] coords = new double[6];
        StringBuilder sb = new StringBuilder();
        while (!pi.isDone()) {
            int kind = pi.currentSegment(coords);
            switch (kind) {
                case PathIterator.SEG_MOVETO:
                    sb.append("MoveTo: ");
                    break;
                case PathIterator.SEG_LINETO:
                    sb.append("LineTo: ");
                    break;
                case PathIterator.SEG_CLOSE:
                    sb.append("Close:  ");
                    break;
                default:
                    throw new IllegalArgumentException("Bad path segment");
            }
            sb.append(Arrays.toString(coords));
            sb.append("\n");
            pi.next();
        }
        return sb.toString();
    }
}