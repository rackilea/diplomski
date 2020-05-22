package javaapplication1.pkg169;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
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
                Rectangle bounds = getDefaultScreenBounds();
                System.out.println(bounds);
                int x = bounds.x + ((bounds.width - frame.getWidth()) / 2);
                frame.setLocation(x, bounds.y + (bounds.height - frame.getHeight()));
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

    public static Rectangle getDefaultScreenBounds() {
        return getScreenBounds(null, true);
    }

    public static Rectangle getScreenBounds(Component comp, boolean acceptDefault) {
        Rectangle bounds = getScreenBounds(comp);
        if ((bounds == null || (bounds.x == 0 && bounds.y == 0 && bounds.width == 0 && bounds.height == 0)) && acceptDefault) {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice gd = ge.getDefaultScreenDevice();
            bounds = gd.getDefaultConfiguration().getBounds();
        }
        return bounds;
    }

    public static Rectangle getScreenBounds(Component comp) {
        Rectangle bounds = new Rectangle(0, 0, 0, 0);
        GraphicsDevice gd = getGraphicsDevice(comp);

        if (gd != null) {
            GraphicsConfiguration gc = gd.getDefaultConfiguration();
            bounds = gc.getBounds();
        }
        return bounds;
    }

    public static GraphicsDevice getGraphicsDevice(Component comp) {
        GraphicsDevice device = null;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice lstGDs[] = ge.getScreenDevices();
        List<GraphicsDevice> lstDevices = new ArrayList<>(lstGDs.length);
        if (comp != null && comp.isVisible()) {
            Rectangle parentBounds = comp.getBounds();
            /*
             * If the component is not a window, we need to find its location on the
             * screen...
             */
            if (!(comp instanceof Window)) {
                Point p = new Point(0, 0);
                SwingUtilities.convertPointToScreen(p, comp);
                parentBounds.setLocation(p);
            }

            for (GraphicsDevice gd : lstGDs) {
                GraphicsConfiguration gc = gd.getDefaultConfiguration();
                Rectangle screenBounds = gc.getBounds();
                if (screenBounds.intersects(parentBounds)) {
                    lstDevices.add(gd);
                }
            }
            if (lstDevices.size() == 1) {
                device = lstDevices.get(0);
            } else {
                GraphicsDevice gdMost = null;
                float maxArea = 0;

                for (GraphicsDevice gd : lstDevices) {
                    GraphicsConfiguration gc = gd.getDefaultConfiguration();
                    Rectangle bounds = gc.getBounds();

                    Rectangle2D intBounds = bounds.createIntersection(parentBounds);
                    float perArea = (float) ((intBounds.getWidth() * intBounds.getHeight()) / (parentBounds.width * parentBounds.height));
                    if (perArea > maxArea) {
                        maxArea = perArea;
                        gdMost = gd;
                    }
                }
                if (gdMost != null) {
                    device = gdMost;
                }
            }
        }

        return device;
    }

}