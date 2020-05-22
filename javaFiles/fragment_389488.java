import java.awt.Polygon;
import java.awt.geom.Area;

public class AreaAddition {

    public void addTriangles() {
        Polygon triangle1 = new Polygon();
        triangle1.addPoint(0, 0);
        triangle1.addPoint(8, 0);
        triangle1.addPoint(0, 8);

        Polygon triangle2 = new Polygon();
        triangle2.addPoint(0, 0);
        triangle2.addPoint(8, 0);
        triangle2.addPoint(8, 8);

        Area a1 = new Area(triangle1);
        Area a2 = new Area(triangle2);
        a1.add(a2);

        // Code that draws the Area belongs here.
    }

}