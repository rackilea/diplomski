import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Path2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ArrowHead extends Path2D.Double {

        public ArrowHead() {
            int size = 10;
            moveTo(0, size);
            lineTo(size / 2, 0);
            lineTo(size, size);
            closePath();
        }

    }

    public class TestPane extends JPanel {

        private ArrowHead arrow = new ArrowHead();
        private double angleOfAttack = 0;

        public TestPane() {
            Timer timer = new Timer(5, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    angleOfAttack += 0.5;
                    repaint();
                }
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Snap shot the current context
            Graphics2D g2d = (Graphics2D) g.create();

            // Translate to somewhere you want the arrow painted ...
            g2d.translate(50, 50);
            // The bounding box of the arrow...
            Rectangle bounds = arrow.getBounds();

            // A guide, showing where the arrow is been painted without the rotation
            g2d.setColor(Color.RED);
            g2d.draw(bounds);

            // Rotate abount the middle of the arrow...
            g2d.rotate(Math.toRadians(angleOfAttack), bounds.width / 2, bounds.height / 2);
            g2d.setColor(Color.BLACK);
            // Draw the arrow
            g2d.fill(arrow);

            // Discard the transformations so we don't effect anyone else
            g2d.dispose();
        }

    }

}