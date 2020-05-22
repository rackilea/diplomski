import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.*;
import javax.swing.*;

public class TestCar {
    private static void createAndShowGui() {
        Car mainPanel = new Car();

        JFrame frame = new JFrame("A Car");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // start all code on the Swing event thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}

class Car extends JPanel {
    private static final int PREF_W = 400;
    private static final int PREF_H = 300;
    private static final Rectangle BODY = new Rectangle(0, 10, 60, 20); 
    private static final Line2D ROOF_1 = new Line2D.Double(10, 10, 20, 0);
    private static final Line2D ROOF_2 = new Line2D.Double(20, 0, 40, 0);
    private static final Line2D ROOF_3 = new Line2D.Double(40, 0, 50, 10); 
    private static final Ellipse2D WHEEL_1 = new Ellipse2D.Double(15, 25, 10,10);
    private static final Ellipse2D WHEEL_2 = new Ellipse2D.Double(45, 25, 10,10);

    public Car() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // draw the rectangle
        g2.draw(BODY);
        g2.draw(ROOF_1);
        g2.draw(ROOF_2);
        g2.draw(ROOF_3);
        g2.draw(WHEEL_1);
        g2.draw(WHEEL_2);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }
}