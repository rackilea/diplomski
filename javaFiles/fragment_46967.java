package javaapplication1.pkg005;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public class SpiralPath extends Path2D.Double {

        public SpiralPath(int size) {
            int numIterations = 5;
            int arcGrowDelta = (size / numIterations) / 2;
            int arcWidth = 0;

            int centerX = size / 2;
            int centerY = size / 2;
            moveTo(centerX, centerY);

            for (int i = 0; i < numIterations; i++) {
                append(new Arc2D.Double(centerX - arcWidth, centerY - arcWidth, 2 * arcWidth, 2 * arcWidth, 180, 180, Arc2D.OPEN), true);
                arcWidth += arcGrowDelta;
                append(new Arc2D.Double(centerX - arcWidth, centerY - arcWidth, 2 * arcWidth - arcGrowDelta, 2 * arcWidth, 0, 180, Arc2D.OPEN), true);
            }
        }

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

        private SpiralPath spiralPath;
        private final Rectangle box;

        private List<Point2D> points;
        private double angle;
        private Point2D pos;
        private int index;

        protected static final double PLAY_TIME = 5000; // 5 seconds...

        private Long startTime;

        public TestPane() {
            spiralPath = new SpiralPath(150);
            box = new Rectangle(0, 0, 10, 10);

            points = new ArrayList<>(25);
            PathIterator pi = spiralPath.getPathIterator(null, 0.01);
            while (!pi.isDone()) {
                double[] coords = new double[6];
                switch (pi.currentSegment(coords)) {
                    case PathIterator.SEG_MOVETO:
                    case PathIterator.SEG_LINETO:
                        points.add(new Point2D.Double(coords[0], coords[1]));
                        break;
                }
                pi.next();
            }

            pos = points.get(0);
            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (startTime == null) {
                        startTime = System.currentTimeMillis();
                    }
                    long playTime = System.currentTimeMillis() - startTime;
                    double progress = playTime / PLAY_TIME;
                    if (progress >= 1.0) {
                        progress = 1d;
                        ((Timer) e.getSource()).stop();
                    }

                    int index = Math.min(Math.max(0, (int) (points.size() * progress)), points.size() - 1);

                    pos = points.get(index);
                    if (index < points.size() - 1) {
                        angle = angleTo(pos, points.get(index + 1));
                    }
                    repaint();
                }
            });

            timer.start();
        }

        protected double angleTo(Point2D from, Point2D to) {
            double angle = Math.atan2(to.getY() - from.getY(), to.getX() - from.getX());
            return angle;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            applyQualityRenderingHints(g2d);
            int x = (getWidth() - spiralPath.getBounds().width) / 2;
            int y = (getHeight() - spiralPath.getBounds().height) / 2;
            g2d.translate(x, y);
            g2d.draw(spiralPath);
            AffineTransform at = new AffineTransform();

            if (pos != null) {

                Rectangle bounds = box.getBounds();
                at.rotate(angle, (bounds.width / 2), (bounds.width / 2));

                Path2D player = new Path2D.Double(box, at);

                g2d.translate(pos.getX() - (bounds.width / 2), pos.getY() - (bounds.height / 2));
                g2d.setColor(Color.RED);
                g2d.draw(player);

            }
            g2d.dispose();
        }

    }

    public static void applyQualityRenderingHints(Graphics2D g2d) {

        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

    }

}