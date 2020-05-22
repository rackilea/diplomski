import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ClockCirclesTest
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
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(1, 0));
        frame.getContentPane().add(new ClockCirclesPanel());
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class ClockCirclesPanel extends JPanel
{
    @Override
    protected void paintComponent(Graphics gr)
    {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D)gr;
        g.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING, 
            RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth() / 2;
        int h = getHeight() / 2;
        Point2D points[] = computePoints(w, h, 12);

        int cx = getWidth() / 2;
        int cy = getHeight() / 2;
        g.translate(cx, cy);
        for (Point2D p : points)
        {
            g.draw(new Ellipse2D.Double(
                p.getX() - 5, p.getY() - 5,
                10, 10));
        }
    }

    private Point2D[] computePoints(double w, double h, int n)
    {
        Point2D points[] = new Point2D[n];
        double angleDeltaRad = Math.PI * 2 / n;
        for (int i=0; i<n; i++)
        {
            double angleRad = i * angleDeltaRad;
            double ca = Math.cos(angleRad);
            double sa = Math.sin(angleRad);
            double x = sa * w/2;
            double y = ca * h/2;
            points[i] = new Point2D.Double(x,y);
        }
        return points;
    }

}