import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class EquilateralTriangleTest
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

        EquilateralTrianglePanel panel = new EquilateralTrianglePanel();
        f.getContentPane().add(panel);

        f.setSize(1000,800);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}

class EquilateralTrianglePanel extends JPanel implements MouseMotionListener
{
    private final Point2D point0;
    private final Point2D point1;

    EquilateralTrianglePanel()
    {
        this.point0 = new Point2D.Double(600,500);
        this.point1 = new Point2D.Double(400,600);
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics gr)
    {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D)gr;

        g.setColor(Color.BLACK);
        g.draw(new Line2D.Double(point0, point1));

        g.setColor(Color.RED);
        draw(g, point0);
        draw(g, point1);

        int x0 = (int)point0.getX();
        int y0 = (int)point0.getY();
        int x1 = (int)point1.getX();
        int y1 = (int)point1.getY();

        Point2D point2a = computeTipPoint(point0, point1, true);
        int x2a = (int)point2a.getX();
        int y2a = (int)point2a.getY();

        g.setColor(Color.BLUE);
        int xCoorda[] = {x0, x1, x2a};
        int yCoorda[] = {y0, y1, y2a};
        g.drawPolygon(xCoorda, yCoorda, 3);

        Point2D point2b = computeTipPoint(point0, point1, false);
        int x2b = (int)point2b.getX();
        int y2b = (int)point2b.getY();

        g.setColor(Color.MAGENTA);
        int xCoordb[] = {x0, x1, x2b};
        int yCoordb[] = {y0, y1, y2b};
        g.drawPolygon(xCoordb, yCoordb, 3);
    }

    private static void draw(Graphics2D g, Point2D p)
    {
        Ellipse2D e = new Ellipse2D.Double(
            p.getX()-3, p.getY()-3, 6, 6);
        g.fill(e);
    }


    @Override
    public void mouseDragged(MouseEvent e)
    {
        point0.setLocation(e.getPoint());
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        point1.setLocation(e.getPoint());
        repaint();
    }

    private static Point2D computeTipPoint(
        Point2D p0, Point2D p1, boolean right)
    {
        double dx = p1.getX() - p0.getX();
        double dy = p1.getY() - p0.getY();
        double length = Math.sqrt(dx*dx+dy*dy);
        double dirX = dx / length;
        double dirY = dy / length;
        double height = Math.sqrt(3)/2 * length;
        double cx = p0.getX() + dx * 0.5;
        double cy = p0.getY() + dy * 0.5;
        double pDirX = -dirY;
        double pDirY = dirX;
        double rx = 0;
        double ry = 0;
        if (right)
        {
            rx = cx + height * pDirX;
            ry = cy + height * pDirY;
        }
        else
        {
            rx = cx - height * pDirX;
            ry = cy - height * pDirY;
        }
        return new Point2D.Double(rx, ry);
    }
}