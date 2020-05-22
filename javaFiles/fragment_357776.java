import java.awt.BasicStroke;
import java.awt.event.MouseAdapter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import javax.swing.*;

public class PenDemoPanel extends JPanel {

    private Point start;
    private Point stop;
    private Shape shape;

    public PenDemoPanel() {
        setBackground(Color.white);
        setPreferredSize(new Dimension(600, 600));
        PathListener listener = new PathListener();
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);

        Graphics2D g2 = (Graphics2D) gc;

        if (start != null && stop != null) {
            BasicStroke stroke = new BasicStroke(1);
            Shape strokedShape = stroke.createStrokedShape(shape);
            g2.draw(strokedShape);
            g2.fill(strokedShape);
        }
    }

    private class PathListener
        extends MouseAdapter {

        public void mousePressed(MouseEvent event) {
            start = event.getPoint();
            Path2D path = new Path2D.Double();
            shape = path;
        }

        public void mouseDragged(MouseEvent event) {
            stop = event.getPoint();

            Path2D path = (Path2D) shape;
            path.moveTo(start.x, start.y);
            path.lineTo(stop.x, stop.y);
            shape = path;
            start = stop;

            repaint();
        }

        public void mouseReleased(MouseEvent event) {
            Path2D path = (Path2D) shape;
            try {
                path.closePath();
            } catch(Exception ingore) {
            }
            shape = path;
            repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PenDemoPanel shapes = new PenDemoPanel();

                JFrame frame = new JFrame("PenDemo");

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(shapes);

                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}