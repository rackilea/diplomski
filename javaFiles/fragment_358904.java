import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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

        private int startAt = 0;
        private int endAt;
        private int x = startAt;
        private Timer timer;
        private SplineInterpolator splineInterpolator;
        private long startTime = -1;
        private long playTime = 5000; // 5 seconds

        public TestPane() {
            splineInterpolator = new SplineInterpolator(1, 0, 0, 1);
            timer = new Timer(5, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (startTime < 0) {
                        startTime = System.currentTimeMillis();
                    }
                    long now = System.currentTimeMillis();
                    long duration = now - startTime;
                    double t = (double) duration / (double) playTime;
                    if (duration >= playTime) {
                        t = 1;
                    }

                    double progress = splineInterpolator.interpolate(t);

                    x = startAt + ((int) Math.round((endAt - startAt) * progress));
                    repaint();
                }
            });
            timer.setInitialDelay(0);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (!timer.isRunning()) {
                        startTime = -1;
                        startAt = 0;
                        endAt = getWidth() - 10;
                        timer.start();
                    }
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.RED);
            g2d.fillRect(x, (getHeight() / 2) - 5, 10, 10);
            g2d.dispose();
        }

    }

    public static class SplineInterpolator {

        private final double points[];
        private final List<PointUnit> normalisedCurve;

        public SplineInterpolator(double x1, double y1, double x2, double y2) {
            points = new double[]{x1, y1, x2, y2};

            final List<Double> baseLengths = new ArrayList<>();
            double prevX = 0;
            double prevY = 0;
            double cumulativeLength = 0;
            for (double t = 0; t <= 1; t += 0.01) {
                Point2D xy = getXY(t);
                double length = cumulativeLength
                                + Math.sqrt((xy.getX() - prevX) * (xy.getX() - prevX)
                                                + (xy.getY() - prevY) * (xy.getY() - prevY));

                baseLengths.add(length);
                cumulativeLength = length;
                prevX = xy.getX();
                prevY = xy.getY();
            }

            normalisedCurve = new ArrayList<>(baseLengths.size());
            int index = 0;
            for (double t = 0; t <= 1; t += 0.01) {
                double length = baseLengths.get(index++);
                double normalLength = length / cumulativeLength;
                normalisedCurve.add(new PointUnit(t, normalLength));
            }
        }

        public double interpolate(double fraction) {
            int low = 1;
            int high = normalisedCurve.size() - 1;
            int mid = 0;
            while (low <= high) {
                mid = (low + high) / 2;

                if (fraction > normalisedCurve.get(mid).getPoint()) {
                    low = mid + 1;
                } else if (mid > 0 && fraction < normalisedCurve.get(mid - 1).getPoint()) {
                    high = mid - 1;
                } else {
                    break;
                }
            }
            /*
             * The answer lies between the "mid" item and its predecessor.
             */
            final PointUnit prevItem = normalisedCurve.get(mid - 1);
            final double prevFraction = prevItem.getPoint();
            final double prevT = prevItem.getDistance();

            final PointUnit item = normalisedCurve.get(mid);
            final double proportion = (fraction - prevFraction) / (item.getPoint() - prevFraction);
            final double interpolatedT = prevT + (proportion * (item.getDistance() - prevT));
            return getY(interpolatedT);
        }

        protected Point2D getXY(double t) {
            final double invT = 1 - t;
            final double b1 = 3 * t * invT * invT;
            final double b2 = 3 * t * t * invT;
            final double b3 = t * t * t;
            final Point2D xy = new Point2D.Double((b1 * points[0]) + (b2 * points[2]) + b3, (b1 * points[1]) + (b2 * points[3]) + b3);
            return xy;
        }

        protected double getY(double t) {
            final double invT = 1 - t;
            final double b1 = 3 * t * invT * invT;
            final double b2 = 3 * t * t * invT;
            final double b3 = t * t * t;
            return (b1 * points[2]) + (b2 * points[3]) + b3;
        }

        public class PointUnit {

            private final double distance;
            private final double point;

            public PointUnit(double distance, double point) {
                this.distance = distance;
                this.point = point;
            }

            public double getDistance() {
                return distance;
            }

            public double getPoint() {
                return point;
            }

        }

    }

}