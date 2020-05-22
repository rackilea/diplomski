import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SimpleShape {

    public static void main(String[] args) {
        new SimpleShape();
    }

    public SimpleShape() {
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

        private RightEnd rightEnd;

        public TestPane() {
            rightEnd = new RightEnd(100, 100, 40);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(100, 100);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int x = (getWidth() - 100) / 2;
            int y = (getHeight()- 100) / 2;
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.translate(x, y);
            g2d.fill(rightEnd);
            g2d.dispose();
        }

    }

    public class RightEnd extends Path2D.Float {

        public RightEnd(float width, float height, float radius) {
            moveTo(0, 0);
            lineTo(width - radius, 0);
            curveTo(width, 0, width, 0, width, radius);
            lineTo(width, height - radius);
            curveTo(width, height, width, height, width - radius, height);
            lineTo(0, height);
            closePath();
        }



    }

}