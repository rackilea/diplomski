import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                TestPane tp = new TestPane();
                JPanel control = new JPanel(new BorderLayout());
                control.add(tp);

                final JSlider startAngel = new JSlider(0, 359);
                final JSlider endAngel = new JSlider(0, 359);

                JPanel sliders = new JPanel(new GridLayout(1, 2));
                sliders.add(startAngel);
                sliders.add(endAngel);

                startAngel.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        tp.setStartAngle(startAngel.getValue());
                    }
                });
                endAngel.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        tp.setEndAngle(endAngel.getValue());
                    }
                });

                startAngel.setValue(0);
                endAngel.setValue(180);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(control);
                frame.add(sliders, BorderLayout.SOUTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private Point startPoint, endPoint;
        private float startAngle = 0;
        private float endAngle = 180;

        public TestPane() {
        }

        @Override
        public void invalidate() {
            super.invalidate();
            recalculate();
        }

        protected void recalculate() {

            int dim = Math.min(getWidth(), getHeight());
            dim -= 50;
            float radius = dim / 2f;

            startPoint = getPointOnCircle(startAngle, radius);
            endPoint = getPointOnCircle(endAngle, radius);

            repaint();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected Point getPointOnCircle(float degress, float radius) {

            int x = Math.round(getWidth() / 2);
            int y = Math.round(getHeight() / 2);

            double rads = Math.toRadians(degress - 90); // 0 becomes the top

            // Calculate the outter point of the line
            int xPosy = Math.round((float) (x + Math.cos(rads) * radius));
            int yPosy = Math.round((float) (y + Math.sin(rads) * radius));

            return new Point(xPosy, yPosy);

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            int[] x = new int[3];
            int[] y = new int[3];
            double distance = startPoint.distance(endPoint);
            double halfDistance = distance / 2;
            double angle = -Math.atan2(endPoint.y - startPoint.y, endPoint.x - startPoint.x);

            System.out.println(angle);

            x[0] = (int) endPoint.getX();
            y[0] = (int) endPoint.getY();

            x[1] = (int) ((Math.sin(angle) * halfDistance) + startPoint.getX());
            y[1] = (int) ((Math.cos(angle) * halfDistance) + startPoint.getY());

            x[2] = (int) (startPoint.getX() - (Math.sin(angle) * halfDistance));
            y[2] = (int) (startPoint.getY() - (Math.cos(angle) * halfDistance));

            g2d.setColor(Color.RED);
            g2d.fillPolygon(x, y, 3);

            g2d.setColor(Color.BLUE);
            g2d.fillOval(startPoint.x - 5, startPoint.y - 5, 10, 10);
            g2d.setColor(Color.GREEN);
            g2d.fillOval(endPoint.x - 5, endPoint.y - 5, 10, 10);

            g2d.dispose();
        }

        public void setStartAngle(float value) {
            startAngle = value;
            recalculate();
        }

        public void setEndAngle(float value) {
            endAngle = value;
            recalculate();
        }

    }

}