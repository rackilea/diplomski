import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.*;

class ShapeCollision {

    private BufferedImage img;
    private Area walls;
    int x;
    int y;
    int xDelta = 3;
    int yDelta = 2;
    ArrayList<Strike> strikes;

    /**
     * A method to determine if two instances of Area intersect
     */
    public boolean doAreasCollide(Area area1, Area area2) {
        boolean collide = false;

        Area collide1 = new Area(area1);
        collide1.subtract(area2);
        if (!collide1.equals(area1)) {
            collide = true;
        }

        Area collide2 = new Area(area2);
        collide2.subtract(area1);
        if (!collide2.equals(area2)) {
            collide = true;
        }

        return collide;
    }

    ShapeCollision() {
        int w = 400;
        int h = 200;
        img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        final JLabel imageLabel = new JLabel(new ImageIcon(img));
        x = w / 2;
        y = h / 2;

        strikes = new ArrayList<Strike>();

        MouseListener strikeListener = new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                Strike s = new Strike(e.getPoint(),System.currentTimeMillis());
                strikes.add(s);
            }
        };
        imageLabel.addMouseListener(strikeListener);

        walls = new Area(new Rectangle(0, 0, w, h));

        ActionListener animate = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                animate();
                imageLabel.repaint();
            }
        };
        Timer timer = new Timer(50, animate);

        timer.start();
        JOptionPane.showMessageDialog(null, imageLabel);
        timer.stop();
    }

    public void animate() {
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, img.getWidth(), img.getHeight());
        x += xDelta;
        y += yDelta;
        int s = 15;
        Area player = new Area(new Ellipse2D.Double(x, y, s, s));

        // Acid test of edge collision;
        if (doAreasCollide(player, walls)) {
            if (x + s > img.getWidth() || x < 0) {
                xDelta *= -1;
            }
            if (y + s > img.getHeight() || y < 0) {
                yDelta *= -1;
            }
        }
        g.setColor(Color.ORANGE);
        g.setColor(Color.YELLOW);
        g.fill(player);

        for (Strike strike : strikes) {
            strike.draw(g);
        }

        g.dispose();
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                new ShapeCollision();
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
        SwingUtilities.invokeLater(r);
    }
}

class Strike {

    private Point point;
    private long started;
    private final long DURATION = 5000;
    private boolean expired = false;

    Strike(Point point, long time) {
        this.point = point;
        started = time;
    }

    public void draw(Graphics g) {
        long now = System.currentTimeMillis();
        long age = now - started;
        if (age>DURATION) {
            expired = true;
            return;
        }
        double fraction = 1d-((double)age/(double)DURATION);
        int alpha = (int)(fraction*255d);
        Color c = new Color(255,255,255,alpha);
        g.setColor(c);
        String s = point.x + "," + point.y;
        g.drawString( s, point.x, point.y );
    }

    public boolean isExpired() {
        return expired;
    }
}