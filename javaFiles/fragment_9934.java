import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
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

    public class TestPane extends JPanel {

        private Slice slice = new Slice(100, 200, 60, 40);

        public TestPane() {
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 400);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            g2d.translate((getWidth() / 2.0) - slice.getBounds().width,
                    (getHeight() - slice.getBounds().height) / 2.0);
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON
            );
            g2d.setRenderingHints(hints);

            Color primaryColor = Color.MAGENTA;
            Color alphaColor = new Color(primaryColor.getRed(), primaryColor.getGreen(), primaryColor.getBlue(), 0);
            Color shadowColor = new Color(0, 0, 0, 128);

            g2d.setColor(primaryColor);
            g2d.fill(slice);

            RadialGradientPaint rgp = new RadialGradientPaint(
                    new Point2D.Double(slice.getBounds2D().getWidth(), slice.getBounds2D().getHeight() / 2d), 
                    (float)slice.getBounds2D().getHeight() / 2.0f, 
                    new float[] {0.6f, 1.0f}, 
                    new Color[] {alphaColor, shadowColor});
            g2d.setPaint(rgp);
            g2d.fill(slice);

            Graphics2D gScale = (Graphics2D) g2d.create();
            LinearGradientPaint lgp = new LinearGradientPaint(
                    new Point2D.Double(0, 0), 
                    new Point2D.Double(slice.getBounds2D().getWidth(), 0), 
                    new float[]{0f, 1f}, 
                    new Color[] {shadowColor, alphaColor});
            gScale.setPaint(lgp);
            gScale.fill(slice);
            lgp = new LinearGradientPaint(
                    new Point2D.Double(slice.getBounds2D().getWidth(), 0), 
                    new Point2D.Double(slice.getBounds2D().getWidth() * 2, 0), 
                    new float[]{0f, 1f}, 
                    new Color[] {alphaColor, shadowColor});
            gScale.setPaint(lgp);
            gScale.fill(slice);
            gScale.dispose();


            g2d.setPaint(primaryColor.brighter());
            g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2d.draw(slice);
            g2d.dispose();
        }

    }

    public class Slice extends Path2D.Double {

        public Slice(double width, double height, double range, double innerHeight) {
            moveTo(0, 0);
            append(new Arc2D.Double(0, 0, width, height,
                    90 - (range / 2.0), range,
                    Arc2D.OPEN), false);

            double sliceWidth = width / 2.0;
            double x = (width - sliceWidth) / 2.0;

            append(new Arc2D.Double(x, height, sliceWidth, innerHeight,
                    90 + (range / 2.0), -range,
                    Arc2D.OPEN), true);

            closePath();
        }
    }

}