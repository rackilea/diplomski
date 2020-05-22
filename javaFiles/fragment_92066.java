import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TriangleTextFieldsTest
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new TriangleTextFieldsTest();
            }
        });
    }

    public TriangleTextFieldsTest()
    {
        JFrame frame = new JFrame();
        frame.getContentPane().add(new TriangleTextFieldsPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}


class TriangleTextFieldsPanel extends JPanel
    implements MouseListener, MouseMotionListener
{
    private final List<Point2D> points;
    private final List<JTextField> textFields;
    private Point2D draggedPoint = null;

    TriangleTextFieldsPanel()
    {
        super(null);

        points = new ArrayList<Point2D>();
        points.add(new Point2D.Double(250,250));
        points.add(new Point2D.Double(750,250));
        points.add(new Point2D.Double(500,500));

        textFields = new ArrayList<JTextField>();

        for (int i=0; i<points.size(); i++)
        {
            JTextField t = new JTextField(10);
            textFields.add(t);
            add(t);
        }

        updateTextFieldPositions();
        updateTextFieldContents();

        addMouseListener(this);
        addMouseMotionListener(this);
    }

    private void updateTextFieldPositions()
    {
        for (int i=0; i<points.size(); i++)
        {
            Point2D p0 = points.get(i);
            Point2D p1 = points.get((i+1)%points.size());

            JTextField textField = textFields.get(i);
            int cx = (int)(0.5 * (p1.getX() + p0.getX()));
            int cy = (int)(0.5 * (p1.getY() + p0.getY()));

            Dimension d = textField.getPreferredSize();
            textField.setBounds(cx, cy, d.width, d.height);
        }
    }

    private void updateTextFieldContents()
    {
        for (int i=0; i<points.size(); i++)
        {
            Point2D p0 = points.get(i);
            Point2D p1 = points.get((i+1)%points.size());

            JTextField textField = textFields.get(i);
            double d = p0.distance(p1);
            textField.setText(String.format("%.2f", d));
        }
    }


    @Override
    protected void paintComponent(Graphics gr)
    {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D)gr;
        g.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,  
            RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.BLUE);
        drawPoints(g, points);

        g.setColor(Color.BLACK);
        for (int i=0; i<points.size(); i++)
        {
            Point2D p0 = points.get(i);
            Point2D p1 = points.get((i+1)%points.size());
            g.draw(new Line2D.Double(p0,p1));
        }
    }

    static void drawPoints(Graphics2D g, List<Point2D> points)
    {
        double r = 3;
        for (Point2D point : points)
        {
            double x = point.getX();
            double y = point.getY();
            g.fill(new Ellipse2D.Double(
                x-r, y-r, r+r, r+r));
        }
    }


    @Override
    public void mouseDragged(MouseEvent e)
    {
        if (draggedPoint != null)
        {
            draggedPoint.setLocation(e.getPoint());
            updateTextFieldPositions();
            updateTextFieldContents();            
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        draggedPoint = null;
        double thresholdSquared = 10*10;
        double minDs = Double.MAX_VALUE;
        for (Point2D point : points)
        {
            double ds = point.distanceSq(e.getPoint());
            if (ds < thresholdSquared && ds < minDs)
            {
                minDs = ds;
                draggedPoint = point;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        draggedPoint = null;
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
    }
}