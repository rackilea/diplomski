import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class ShapeCenter
{
    public static void main(String[] args)
    {
        System.out.println(computeCenter(new Ellipse2D.Double(-10,-10,20,20)));
        System.out.println(computeCenter(new Rectangle2D.Double(0,0,1,1)));
    }

    public static Point2D computeCenter(Shape shape)
    {
        final double flatness = 0.1;
        PathIterator pi = shape.getPathIterator(null, flatness);
        double coords[] = new double[6];
        double sumX = 0;
        double sumY = 0;
        int numPoints = 0;
        while (!pi.isDone())
        {
            int s = pi.currentSegment(coords);
            switch (s)
            {
                case PathIterator.SEG_MOVETO:
                    // Ignore
                    break;

                case PathIterator.SEG_LINETO:
                    sumX += coords[0]; 
                    sumY += coords[1]; 
                    numPoints++;
                    break;

                case PathIterator.SEG_CLOSE:
                    // Ignore
                    break;

                case PathIterator.SEG_QUADTO:
                    throw new AssertionError(
                        "SEG_QUADTO in flattening path iterator");
                case PathIterator.SEG_CUBICTO:
                    throw new AssertionError(
                        "SEG_CUBICTO in flattening path iterator");
            }
            pi.next();
        }
        double x = sumX / numPoints;
        double y = sumY / numPoints;
        return new Point2D.Double(x,y);
    }

}