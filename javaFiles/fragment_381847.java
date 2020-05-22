package mcve.game;

import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.GraphicsConfiguration;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class MovementExample implements ActionListener {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MovementExample::new);
    }

    final int fps    = 60;
    final int period = 1000 / fps;

    final JFrame    frame;
    final GamePanel panel;
    final Controls  controls;
    final Ship      ship;

    final List<Bullet> bullets = new ArrayList<>();

    MovementExample() {
        frame = new JFrame("Movement Example");

        Dimension size = getMaximumWindowSize(frame);
        size.width  /= 2;
        size.height /= 2;
        frame.setPreferredSize(size);

        panel = new GamePanel();
        frame.setContentPane(panel);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        controls = new Controls();

        ship = new Ship(panel.getWidth()  / 2,
                        panel.getHeight() / 2);

        new Timer(period, this).start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double secondsElapsed = 1.0 / fps;
        ship.update(secondsElapsed);

        bullets.forEach(b -> b.update(secondsElapsed));
        Rectangle bounds = panel.getBounds();
        bullets.removeIf(b -> !bounds.contains(b.locX, b.locY));

        panel.repaint();
    }

    class GamePanel extends JPanel {
        GamePanel() {
            setBackground(Color.WHITE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON);

            if (ship != null) {
                ship.draw(g2);
            }
            bullets.forEach(b -> b.draw(g2));

            g2.dispose();
        }
    }

    abstract class AbstractGameObject {
        double maxSpeed;
        double rotationAngle;
        double locX;
        double locY;
        double velX;
        double velY;

        AbstractGameObject(double initialX, double initialY) {
            locX = initialX;
            locY = initialY;
        }

        abstract void update(double secondsElapsed);
        abstract void draw(Graphics2D g2);
    }

    class Ship extends AbstractGameObject {
        Polygon shape;
        double  rotationRate;

        Ship(double initialX, double initialY) {
            super(initialX, initialY);
            maxSpeed      = 128; // pixels/second
            rotationAngle = Math.PI * 3 / 2;
            rotationRate  = (2 * Math.PI) / 2; // radians/second

            int xPoints[] = {0, -20, 0, 20};
            int yPoints[] = {0, 60, 40, 60};
            shape = new Polygon(xPoints, yPoints, 4);
        }

        Point2D.Double getTip() {
            Point2D.Double center = getCenter();
            // The tip is at (0,0) and it's already centered
            // on the x-axis origin, so the distance from the
            // tip to the center is just center.y.
            double distance = center.y;
            // Then find the location of the tip, relative
            // to the center.
            double tipX = distance * Math.cos(rotationAngle);
            double tipY = distance * Math.sin(rotationAngle);
            // Now find the actual location of the center.
            center.x += locX;
            center.y += locY;
            // And return the actual location of the tip, relative
            // to the actual location of the center.
            return new Point2D.Double(tipX + center.x, tipY + center.y);
        }

        Point2D.Double getCenter() {
            // Returns the center point of the ship,
            // relative to (0,0).
            Point2D.Double center = new Point2D.Double();
            for (int i = 0; i < shape.npoints; ++i) {
                center.x += shape.xpoints[i];
                center.y += shape.ypoints[i];
            }
            center.x /= shape.npoints;
            center.y /= shape.npoints;
            return center;
        }

        @Override
        void update(double secondsElapsed) {
            // See my answer here: https://stackoverflow.com/a/43692434/2891664
            // for a discussion of why this logic is the way it is.
            double speed = 0;
            if (controls.isUpHeld()) {
                speed += maxSpeed;
            }
            if (controls.isDownHeld()) {
                speed -= maxSpeed;
            }
            velX  = speed * Math.cos(rotationAngle);
            velY  = speed * Math.sin(rotationAngle);
            locX += secondsElapsed * velX;
            locY += secondsElapsed * velY;

            double rotation = 0;
            if (controls.isLeftHeld()) {
                rotation -= rotationRate;
            }
            if (controls.isRightHeld()) {
                rotation += rotationRate;
            }
            rotationAngle += secondsElapsed * rotation;
            // Cap the angle so it can never e.g. get so
            // large that it loses precision.
            if (rotationAngle > 2 * Math.PI) {
                rotationAngle -= 2 * Math.PI;
            }

            if (controls.isFireHeld()) {
                Point2D.Double tipLoc = getTip();
                Bullet bullet = new Bullet(tipLoc.x, tipLoc.y, rotationAngle);
                bullets.add(bullet);
            }
        }

        @Override
        void draw(Graphics2D g2) {
            Graphics2D copy = (Graphics2D) g2.create();
            copy.setColor(Color.RED);

            // Translate to the ship's location.
            copy.translate(locX, locY);
            // Rotate the ship around its center.
            Point2D.Double center = getCenter();
            // The PI/2 offset is necessary because the
            // polygon points are defined with the ship
            // already vertical, i.e. at an angle of -PI/2.
            copy.rotate(rotationAngle + (Math.PI / 2), center.x, center.y);

            copy.fill(shape);
        }
    }

    class Bullet extends AbstractGameObject {
        Ellipse2D.Double shape = new Ellipse2D.Double();

        Bullet(double initialX, double initialY, double initialRotation) {
            super(initialX, initialY);
            maxSpeed      = 512;
            rotationAngle = initialRotation;
            velX          = maxSpeed * Math.cos(rotationAngle);
            velY          = maxSpeed * Math.sin(rotationAngle);

            double radius = 3;
            shape.setFrame(-radius, -radius, 2 * radius, 2 * radius);
        }

        @Override
        void update(double secondsElapsed) {
            locX += secondsElapsed * velX;
            locY += secondsElapsed * velY;
        }

        @Override
        void draw(Graphics2D g2) {
            Graphics2D copy = (Graphics2D) g2.create();
            copy.setColor(Color.BLACK);
            copy.translate(locX, locY);
            copy.fill(shape);
        }
    }

    // See https://docs.oracle.com/javase/tutorial/uiswing/misc/keybinding.html
    class Controls {
        final Set<Integer> keysHeld = new HashSet<>();

        Controls() {
            bind(KeyEvent.VK_A, "left");
            bind(KeyEvent.VK_D, "right");
            bind(KeyEvent.VK_W, "up");
            bind(KeyEvent.VK_S, "down");
            bind(KeyEvent.VK_SPACE, "fire");
        }

        boolean isLeftHeld()  { return keysHeld.contains(KeyEvent.VK_A); }
        boolean isRightHeld() { return keysHeld.contains(KeyEvent.VK_D); }
        boolean isUpHeld()    { return keysHeld.contains(KeyEvent.VK_W); }
        boolean isDownHeld()  { return keysHeld.contains(KeyEvent.VK_S); }
        boolean isFireHeld()  { return keysHeld.contains(KeyEvent.VK_SPACE); }

        void bind(int keyCode, String name) {
            bind(keyCode, name, true);
            bind(keyCode, name, false);
        }

        void bind(int keyCode, String name, boolean isOnRelease) {
            KeyStroke stroke = KeyStroke.getKeyStroke(keyCode, 0, isOnRelease);
            name += isOnRelease ? ".released" : ".pressed";
            panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                 .put(stroke, name);
            panel.getActionMap()
                 .put(name, new AbstractAction() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                         if (isOnRelease) {
                             keysHeld.remove(keyCode);
                         } else {
                             keysHeld.add(keyCode);
                         }
                     }
                 });
        }
    }

    // This returns the usable size of the display which
    // the JFrame resides in, as described here:
    // http://docs.oracle.com/javase/8/docs/api/java/awt/GraphicsEnvironment.html#getMaximumWindowBounds--
    static Dimension getMaximumWindowSize(JFrame frame) {
        GraphicsConfiguration config = frame.getGraphicsConfiguration();
        Dimension size   = config.getBounds().getSize();
        Insets    insets = Toolkit.getDefaultToolkit().getScreenInsets(config);
        size.width  -= insets.left + insets.right;
        size.height -= insets.top  + insets.bottom;
        return size;
    }
}