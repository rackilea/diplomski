import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class RectangleSnap
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        RectangleSnapPanel panel = new RectangleSnapPanel();
        f.getContentPane().add(panel);

        f.setSize(1000,1000);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}

class SnapRectangle
{
    private Point2D position;
    private double sizeX;
    private double sizeY;
    private double angleRad;

    private AffineTransform at;


    SnapRectangle(
        double x, double y, 
        double sizeX, double sizeY, double angleRad)
    {
        this.position = new Point2D.Double(x,y);
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.angleRad = angleRad;

        at = AffineTransform.getRotateInstance(
            angleRad, position.getX(), position.getY());
    }

    double getAngleRad()
    {
        return angleRad;
    }

    double getSizeX()
    {
        return sizeX;
    }

    double getSizeY()
    {
        return sizeY;
    }

    Point2D getPosition()
    {
        return position;
    }

    void draw(Graphics2D g)
    {
        Color oldColor = g.getColor();

        Rectangle2D r = new Rectangle2D.Double(
            position.getX(),  position.getY(), sizeX,  sizeY);
        AffineTransform at = AffineTransform.getRotateInstance(
            angleRad, position.getX(), position.getY());
        g.draw(at.createTransformedShape(r));

        g.setColor(Color.RED);
        for (int i=0; i<4; i++)
        {
            Point2D c = getCorner(i);
            Ellipse2D e = new Ellipse2D.Double(c.getX()-3, c.getY()-3, 6, 6);
            g.fill(e);
            g.drawString(""+i, (int)c.getX(), (int)c.getY()+15);
        }

        g.setColor(Color.GREEN);
        for (int i=0; i<4; i++)
        {
            Point2D c = getEdgeCenter(i);
            Ellipse2D e = new Ellipse2D.Double(c.getX()-3, c.getY()-3, 6, 6);
            g.fill(e);
            g.drawString(""+i, (int)c.getX(), (int)c.getY()+15);
        }

        g.setColor(oldColor);
    }

    Point2D getCorner(int i)
    {
        switch (i)
        {
            case 0:
                return new Point2D.Double(position.getX(), position.getY());
            case 1:
            {
                Point2D.Double result = new Point2D.Double(
                    position.getX(), position.getY()+sizeY);
                return at.transform(result, null);
            }
            case 2:
            {
                Point2D.Double result = new Point2D.Double
                    (position.getX()+sizeX, position.getY()+sizeY);
                return at.transform(result, null);
            }
            case 3:
            {
                Point2D.Double result = new Point2D.Double(
                    position.getX()+sizeX, position.getY());
                return at.transform(result, null);
            }
        }
        return null;
    }

    Line2D getEdge(int i)
    {
        Point2D p0 = getCorner(i); 
        Point2D p1 = getCorner((i+1)%4);
        return new Line2D.Double(p0, p1);
    }

    Point2D getEdgeCenter(int i)
    {
        Point2D p0 = getCorner(i); 
        Point2D p1 = getCorner((i+1)%4);
        Point2D c = new Point2D.Double(
            p0.getX() + 0.5 * (p1.getX() - p0.getX()),
            p0.getY() + 0.5 * (p1.getY() - p0.getY()));
        return c;
    }

    void setPosition(double x, double y)
    {
        this.position.setLocation(x, y);
        at = AffineTransform.getRotateInstance(
            angleRad, position.getX(), position.getY());
    }
}


class RectangleSnapPanel extends JPanel implements MouseMotionListener
{
    private final SnapRectangle rectangle0;
    private final SnapRectangle rectangle1;
    private SnapRectangle snappedRectangle0;

    RectangleSnapPanel()
    {
        this.rectangle0 = new SnapRectangle(
            200, 300, 250, 200, Math.toRadians(-21));
        this.rectangle1 = new SnapRectangle(
            500, 300, 200, 150, Math.toRadians(36));
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics gr)
    {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D)gr;

        g.setColor(Color.BLACK);
        rectangle0.draw(g);
        rectangle1.draw(g);
        if (snappedRectangle0 != null)
        {
            g.setColor(Color.BLUE);
            snappedRectangle0.draw(g);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        rectangle0.setPosition(e.getX(), e.getY());

        snappedRectangle0 = snapRects(rectangle0, rectangle1);

        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
    }


    private static SnapRectangle snapRects(
        SnapRectangle r0, SnapRectangle r1)
    {
        List<Integer> candidateEdgeIndices1 = 
            computeCandidateEdgeIndices1(r0, r1);

        int bestEdgeIndices[] = computeBestEdgeIndices(
            r0, r1, candidateEdgeIndices1);

        int bestEdgeIndex0 = bestEdgeIndices[0];
        int bestEdgeIndex1 = bestEdgeIndices[1];

        System.out.println("Best to snap "+bestEdgeIndex0+" to "+bestEdgeIndex1);

        Line2D bestEdge0 = r0.getEdge(bestEdgeIndex0);
        Line2D bestEdge1 = r1.getEdge(bestEdgeIndex1);
        double edgeAngle = angleRad(bestEdge0, bestEdge1);
        double rotationAngle = edgeAngle;

        if (rotationAngle <= Math.PI)
        {
            rotationAngle = Math.PI + rotationAngle;
        }
        else if (rotationAngle <= -Math.PI / 2)
        {
            rotationAngle = Math.PI + rotationAngle;
        }
        else if (rotationAngle >= Math.PI)
        {
            rotationAngle = -Math.PI + rotationAngle;
        }

        SnapRectangle result = new SnapRectangle(
            r0.getPosition().getX(), r0.getPosition().getY(), 
            r0.getSizeX(), r0.getSizeY(), r0.getAngleRad()-rotationAngle);

        Point2D edgeCenter0 = result.getEdgeCenter(bestEdgeIndex0);
        Point2D edgeCenter1 = r1.getEdgeCenter(bestEdgeIndex1);
        double dx = edgeCenter1.getX() - edgeCenter0.getX();
        double dy = edgeCenter1.getY() - edgeCenter0.getY();
        result.setPosition(
            r0.getPosition().getX()+dx,
            r0.getPosition().getY()+dy);

        return result;
    }

    // Compute for the edge indices for r1 in the given list
    // the one that has the smallest distance to any edge
    // of r0, and return this pair of indices
    private static int[] computeBestEdgeIndices(
        SnapRectangle r0, SnapRectangle r1,
        List<Integer> candidateEdgeIndices1)
    {
        int bestEdgeIndex0 = -1;
        int bestEdgeIndex1 = -1;
        double minCenterDistance = Double.MAX_VALUE;
        for (int i=0; i<candidateEdgeIndices1.size(); i++)
        {
            int edgeIndex1 = candidateEdgeIndices1.get(i);
            for (int edgeIndex0=0; edgeIndex0<4; edgeIndex0++)
            {
                Point2D p0 = r0.getEdgeCenter(edgeIndex0);
                Point2D p1 = r1.getEdgeCenter(edgeIndex1);
                double distance = p0.distance(p1);
                if (distance < minCenterDistance)
                {
                    minCenterDistance = distance;
                    bestEdgeIndex0 = edgeIndex0;
                    bestEdgeIndex1 = edgeIndex1;
                }
            }
        }
        return new int[]{ bestEdgeIndex0, bestEdgeIndex1 };
    }

    // Compute the angle, in radians, between the given lines,
    // in the range (-2*PI, 2*PI)
    private static double angleRad(Line2D line0, Line2D line1)
    {
        double dx0 = line0.getX2() - line0.getX1();
        double dy0 = line0.getY2() - line0.getY1();
        double dx1 = line1.getX2() - line1.getX1();
        double dy1 = line1.getY2() - line1.getY1();
        double a0 = Math.atan2(dy0, dx0);
        double a1 = Math.atan2(dy1, dx1);
        return (a0 - a1) % (2 * Math.PI);
    }

    // In these methods, "right" refers to screen coordinates, which 
    // unfortunately are upside down in Swing. Mathematically, 
    // these relation is "left"

    // Compute the "candidate" edges of r1 to which r0 may
    // be snapped. These are the edges to which the maximum
    // number of corners of r0 are right of 
    private static List<Integer> computeCandidateEdgeIndices1(
        SnapRectangle r0, SnapRectangle r1)
    {
        List<Integer> bestEdgeIndices = new ArrayList<Integer>();
        int maxRight = 0;
        for (int i=0; i<4; i++)
        {
            Line2D e1 = r1.getEdge(i);
            int right = countRightOf(e1, r0);
            if (right > maxRight)
            {
                maxRight = right;
                bestEdgeIndices.clear();
                bestEdgeIndices.add(i);
            }
            else if (right == maxRight)
            {
                bestEdgeIndices.add(i);
            }
        }
        //System.out.println("Candidate edges "+bestEdgeIndices);
        return bestEdgeIndices;
    }

    // Count the number of corners of the given rectangle
    // that are right of the given line
    private static int countRightOf(Line2D line, SnapRectangle r)
    {
        int count = 0;
        for (int i=0; i<4; i++)
        {
            if (isRightOf(line, r.getCorner(i)))
            {
                count++;
            }
        }
        return count;
    }

    // Returns whether the given point is right of the given line
    // (referring to the actual line *direction* - not in terms 
    // of coordinates in 2D!)
    private static boolean isRightOf(Line2D line, Point2D point)
    {
        double d00 = line.getX1() - point.getX();
        double d01 = line.getY1() - point.getY();
        double d10 = line.getX2() - point.getX();
        double d11 = line.getY2() - point.getY();
        return d00 * d11 - d10 * d01 > 0;
    }

}