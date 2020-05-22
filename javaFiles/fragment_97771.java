import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Bounce {

    public static void main(String[] args) {
        new Bounce();
    }

    public Bounce() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new BallPitPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class BallPitPane extends JPanel {

        private List<Ball> balls;
        private Random rand;

        public BallPitPane() {
            rand = new Random(System.currentTimeMillis());
            balls = new ArrayList<>(25);
            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (balls.isEmpty()) {
                        balls.add(new Ball(BallPitPane.this));
                    }

                    if (rand.nextBoolean()) {
                        balls.add(new Ball(BallPitPane.this));
                    }

                    for (Ball ball : balls) {
                        ball.move();
                    }
                    repaint();
                }
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            for (Ball ball : balls) {
                ball.paint(g2d);
            }
            g2d.dispose();
        }
    }

    protected static int random(int min, int max) {

        return (int)Math.round(Math.random() * (max - min)) + min;

    }

    public static class Ball {

        public static final int WIDTH = 10;
        public static final int HEIGHT = 10;

        private int x;
        private int y;

        private int deltaX;
        private int deltaY;

        private Color color;
        private BallPitPane parent;

        public Ball(BallPitPane parent) {
            this.parent = parent;
            x = parent.getWidth() / 2;
            y = parent.getHeight() / 2;

            deltaX = random(-4, 4);
            deltaY = random(-4, 4);

            color = new Color(random(0, 255), random(0, 255), random(0, 255));
        }

        public void move() {
            x += deltaX;
            y += deltaY;

            if (x + WIDTH > parent.getWidth()) {
                x = parent.getWidth() - WIDTH;
                deltaX *= -1;
            } else if (x < 0) {
                x = 0;
                deltaX *= -1;
            }
            if (y + HEIGHT > parent.getHeight()) {
                y = parent.getHeight() - HEIGHT;
                deltaY *= -1;
            } else if (y < 0) {
                y = 0;
                deltaY *= -1;
            }
        }

        public Color getColor() {
            return color;
        }

        public void paint(Graphics2D g2d) {

            g2d.setColor(getColor());
            g2d.fillOval(x, y, WIDTH, HEIGHT);
            g2d.setColor(Color.BLACK);
            g2d.drawOval(x, y, WIDTH, HEIGHT);

        }        
    }    
}