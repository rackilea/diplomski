package paint;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;

import java.util.ArrayList;

import javax.swing.JPanel;

public class NPaintCanvas extends JPanel {
    ArrayList<Line2D> l;
    Point actualPoint;
    Point previousPoint;

    public NPaintCanvas() {
    new NPaintMouseEvents(this);
      l = new ArrayList<>();
    }



  @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Line2D ll : l) {
            g2d.draw(ll);
        }
        if (previousPoint != null && actualPoint != null) {
            l.add(new Line2D.Double(previousPoint.x, previousPoint.y, actualPoint.x, actualPoint.y));
            previousPoint = new Point(actualPoint.x, actualPoint.y);
        }
        g.dispose();
        repaint();
    }

    public void mouseReleased() {
        previousPoint = null;
        actualPoint = null;
    }

    public void mousePressed(int x, int y) {
        previousPoint = new Point(x, y);
    }
}