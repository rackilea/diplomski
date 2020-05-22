import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import javax.swing.*;

/** @see http://stackoverflow.com/questions/3405799 */
public class AffineTest extends JPanel implements ActionListener {

    private static final double DELTA_THETA = Math.PI / 45; // 4°
    private static final double DELTA_SCALE = 0.1;
    private int[] p1x = {200, 200, 240, 240, 220, 220, 200};
    private int[] p1y = {200, 260, 260, 240, 240, 200, 200};
    private int[] p2x = {600, 600, 620, 620, 640, 640, 660, 660, 600};
    private int[] p2y = {400, 420, 420, 460, 460, 420, 420, 400, 400};
    private int[] p3x = {400, 400, 460, 460, 440, 440, 420, 420, 400};
    private int[] p3y = {400, 460, 460, 400, 400, 440, 440, 400, 400};
    private Polygon p1 = new Polygon(p1x, p1y, p1x.length);
    private Polygon p2 = new Polygon(p2x, p2y, p2x.length);
    private Polygon p3 = new Polygon(p3x, p3y, p3x.length);
    private AffineTransform at = new AffineTransform();
    private double dt = DELTA_THETA;
    private double theta;
    private double ds = DELTA_SCALE;
    private double scale = 1;
    private Timer timer = new Timer(100, this);

    public AffineTest() {
        this.setPreferredSize(new Dimension(700, 700));
        this.setBackground(Color.white);
        p1.translate(-50, +100);
        p2.translate(-100, -100);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        theta += dt;
        scale += ds;
        if (scale < .5 || scale > 4) {
            ds = -ds;
        }
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        int w = this.getWidth();
        int h = this.getHeight();
        g2d.drawLine(w / 2, 0, w / 2, h);
        g2d.drawLine(0, h / 2, w, h / 2);
        g2d.rotate(theta, w / 2, h / 2);
        g2d.drawPolygon(p1);
        g2d.drawPolygon(p2);
        at.setToIdentity();
        at.translate(w / 2, h / 2);
        at.scale(scale, scale);
        at.translate(-p3x[5] + 10, -p3y[5]);
        g2d.setPaint(Color.blue);
        g2d.fill(at.createTransformedShape(p3));
    }

    public void start() {
        timer.start();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Affine Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AffineTest sl = new AffineTest();
        frame.add(sl);
        frame.pack();
        frame.setVisible(true);
        sl.start();
    }
}