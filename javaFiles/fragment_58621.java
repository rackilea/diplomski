import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private Shape player;
        private Point playerPoint;
        private float angle;
        private float deltaZ = 1.0f;

        private int deltaX, deltaY;

        public TestPane() {
            player = new Rectangle(0, 0, 20, 20);
            playerPoint = new Point(80, 80);
            Random rnd = new Random();
            deltaX = 1;
            deltaY = -1;

            Timer timer = new Timer(5, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    playerPoint.x += deltaX;
                    playerPoint.y += deltaY;

                    Shape rotatedPlayer = rotatedAndTranslatedPlayer();
                    Rectangle2D bounds = rotatedPlayer.getBounds2D();
                    if (bounds.getX() < 0.0) {
                        playerPoint.x = (int)(bounds.getX() * -1);
                        deltaX *= -1;
                    } else if (bounds.getX() + bounds.getWidth() >= getWidth()) {
                        playerPoint.x = getWidth() - (int)bounds.getWidth();
                        deltaX *= -1;
                    }
                    if (bounds.getY() < 0) {
                        playerPoint.y = 0;
                        deltaY *= -1;
                    } else if (bounds.getY() + bounds.getHeight() > getHeight()) {
                        playerPoint.y = getHeight() - (int)bounds.getHeight();
                        deltaY *= -1;
                    }
                    angle += deltaZ;
                    repaint();
                }
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected Shape rotatedAndTranslatedPlayer() {
            Path2D.Double rotated = new Path2D.Double(player,  AffineTransform.getRotateInstance(
                    Math.toRadians(angle),
                    player.getBounds2D().getCenterX(), 
                    player.getBounds2D().getCenterY()));
            return new Path2D.Double(rotated, AffineTransform.getTranslateInstance(playerPoint.x, playerPoint.y));            
        }

        // Simply paints the "area" that the player takes up when it's rotated and
        // translated
        protected void paintAutoTranslatedShape(Graphics2D g2d) {
            g2d.setColor(Color.DARK_GRAY);
            g2d.fill(rotatedAndTranslatedPlayer().getBounds2D());
        }

        // Uses a AffineTransform to translate and rotate the player
        protected void paintPlayer(Graphics2D g2d) {
            AffineTransform at = AffineTransform.getTranslateInstance(playerPoint.x, playerPoint.y);
            at.rotate(Math.toRadians(angle), player.getBounds2D().getCenterX(), player.getBounds2D().getCenterY());
            g2d.setTransform(at);
            g2d.setColor(Color.RED);
            g2d.fill(player);
            g2d.setColor(Color.BLACK);
            g2d.draw(player);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            paintAutoTranslatedShape(g2d);
            g2d.dispose();
            g2d = (Graphics2D) g.create();
            paintPlayer(g2d);
            g2d.dispose();
        }

    }
}