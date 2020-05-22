import java.awt.Polygon;
import java.awt.geom.PathIterator;
class ShapeTest {
    /**
     * Use points to make a pentagon
              . 2,5
        0,3 .   . 4,3
        0,1 .   . 4,1

     */
    public static void main(String...args) {
        // from the top clockwise
        int[] xClock = new int[] { 2,4,4,0,0 };
        int[] yClock = new int[] { 5,4,1,1,3 };

        // the reverse order from the clockwise way
        int[] xCounter = new int[] { 0,0,4,4,2 };
        int[] yCounter = new int[] { 3,1,1,4,5 };

        Polygon clock = new Polygon(xClock, yClock, 5);
        Polygon counter = new Polygon(xCounter, yCounter, 5);

        int index = 0;

        System.out.println("Walking clockwise");
        PathIterator clockIter = clock.getPathIterator(null);

        while(!clockIter.isDone() && index < clock.npoints) {
            float[] coords = new float[6];
            clockIter.currentSegment(coords);
            System.out.println("Currently at: " + coords[0] + " " + coords[1]);
            clockIter.next();
            index++;
        }

        index = 0;

        System.out.println("Walking counter-clockwise");
        PathIterator counterIter = counter.getPathIterator(null);
        while(!counterIter.isDone() && index < counter.npoints) {
            float[] coords = new float[6];
            counterIter.currentSegment(coords);
            System.out.println("Currently at: " + coords[0] + " " + coords[1]);
            counterIter.next();
            index++;
        }

    }
}