import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestRotate01 {

    public static void main(String[] args) {
        new TestRotate01();
    }

    public TestRotate01() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private CrossShape prop;

        private double angle;

        public TestPane() {
            prop = new CrossShape(50, 50);
            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    angle += 5;
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
            Graphics2D g2d = (Graphics2D) g.create();
            AffineTransform current = g2d.getTransform();

            int x = 25;
            int y = (getHeight() - prop.getBounds().height) / 2;

            AffineTransform at = new AffineTransform();
            at.translate(x, y);
            at.rotate(Math.toRadians(angle), prop.getBounds().width / 2, prop.getBounds().height / 2);
            g2d.setTransform(at);
            g2d.setColor(Color.RED);
            g2d.draw(prop);

            // Reset...
            // Equally, you could dispose of the g2d and create a new copy
            g2d.setTransform(current);

            x = getWidth() - 25 - prop.getBounds().width;
            y = (getHeight() - prop.getBounds().height) / 2;

            at = new AffineTransform();
            at.translate(x, y);
            at.rotate(Math.toRadians(-angle), prop.getBounds().width / 2, prop.getBounds().height / 2);
            g2d.setTransform(at);
            g2d.setColor(Color.BLUE);
            g2d.draw(prop);

            g2d.dispose();
        }

    }

    public class CrossShape extends Path2D.Double {

        public CrossShape(int width, int height) {

            moveTo(0, 0);
            lineTo(width, height);
            moveTo(width, 0);
            lineTo(0, height);

        }

    }

}