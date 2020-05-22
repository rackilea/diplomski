import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Car2 extends JPanel {
    private static final int PREF_W = 400;
    private static final int PREF_H = 300;
    private static final Rectangle BODY = new Rectangle(0, 10, 60, 20);
    private static final Line2D ROOF_1 = new Line2D.Double(10, 10, 20, 0);
    private static final Line2D ROOF_2 = new Line2D.Double(20, 0, 40, 0);
    private static final Line2D ROOF_3 = new Line2D.Double(40, 0, 50, 10);
    private static final Ellipse2D WHEEL_1 = new Ellipse2D.Double(15, 25, 10,
            10);
    private static final Ellipse2D WHEEL_2 = new Ellipse2D.Double(45, 25, 10,
            10);
    private static final int TIMER_DELAY = 30;
    private static final int CAR_DELTA_X = 1;
    private static final int CAR_DELTA_Y = CAR_DELTA_X;
    private Path2D path2D = new Path2D.Double();

    public Car2() {
        path2D.append(BODY, false);
        path2D.append(ROOF_1, false);
        path2D.append(ROOF_2, false);
        path2D.append(ROOF_3, false);
        path2D.append(WHEEL_1, false);
        path2D.append(WHEEL_2, false);

        new Timer(TIMER_DELAY, new CarTimerListener()).start();;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(path2D);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    class CarTimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            path2D.transform(AffineTransform.getTranslateInstance(CAR_DELTA_X, CAR_DELTA_Y));
            repaint();
        }
    }
}