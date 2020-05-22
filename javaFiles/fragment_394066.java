import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.opencv.core.Point;
import org.opencv.core.RotatedRect;
import org.opencv.core.Size;

public class TestFrame extends JFrame {
    public static void main(String... args) {
        final TestFrame frame = new TestFrame();
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);
            }
        });
    }

    private RectComponent rect;

    public TestFrame() {
        JPanel containerPane = new JPanel(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        rect = new RectComponent();
        containerPane.add(rect);
        setContentPane(containerPane);
        setSize(400,400);
        new Timer(100, rect).start();
    }

    public class RectComponent extends JComponent implements ActionListener {
        private RotatedRect rect = new RotatedRect(new Point(0,0), new Size(1, 3), 0);

        private final Point[] pts = new Point[4];

        @Override
        protected void paintComponent(Graphics g) {
            rect.points(pts);
            printPoints();
            Dimension size = getSize();
            drawRectLine(g, pts[0], pts[1], size);
            drawRectLine(g, pts[1], pts[2], size);
            drawRectLine(g, pts[2], pts[3], size);
            drawRectLine(g, pts[0], pts[3], size);
        }

        private void printPoints() {
            System.out.format("A: %d, TL: %s, TR: %s, BR: %s, BL%s%n",
                    (int) (rect.angle + (rect.angle < 0 ? -1e-6 : 1e-6)), // Stupid doubles, stupid rounding error
                    pointToString(pts[0]),
                    pointToString(pts[3]),
                    pointToString(pts[2]),
                    pointToString(pts[1]));
        }

        private String pointToString(Point p) {
            return String.format("{%.2f,%.2f}",p.x, p.y);
        }

        private void drawRectLine(Graphics g, Point left, Point right, Dimension size) {
            g.drawLine(scale(left.x, size.width), scale(left.y, size.height),
                    scale(right.x, size.width), scale(right.y, size.height));
        }


        private int scale(double value, int coord) {
            return (int) (value * coord) / 4 + coord / 2;
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            rect.angle += 1;
            if(rect.angle > 44) rect.angle = -44;
            repaint();
        }
    }
}