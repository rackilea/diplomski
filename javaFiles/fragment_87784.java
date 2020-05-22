import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class AnimationBackground {

    public AnimationBackground() {
        Random random = new Random();
        JFrame frame = new JFrame("Animation Background");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        final MyJPanel panel = new MyJPanel();
        panel.setBackground(Color.BLACK);
        for (int i = 0; i < 50; i++) {
            Star star = new Star(new Point(random.nextInt(490), random.nextInt(490)));
            star.setColor(new Color(100 + random.nextInt(155), 100 + random.nextInt(155), 100 + random.nextInt(155)));
            star.setxIncr(-3 + random.nextInt(7));
            star.setyIncr(-3 + random.nextInt(7));
            panel.add(star);
        }
        panel.setLayout(new GridLayout(10, 1));
        JLabel label = new JLabel("This is a Starry background.", JLabel.CENTER);
        label.setForeground(Color.WHITE);
        panel.add(label);
        JPanel stopPanel = new JPanel();
        stopPanel.setOpaque(false);
        stopPanel.add(new JButton(new AbstractAction("Stop this madness!!") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                panel.stopAnimation();
            }
        }));
        panel.add(stopPanel);
        JPanel startPanel = new JPanel();
        startPanel.setOpaque(false);
        startPanel.add(new JButton(new AbstractAction("Start moving...") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                panel.startAnimation();
            }
        }));
        panel.add(startPanel);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                AnimationBackground animationBackground = new AnimationBackground();
            }
        });
    }

    class Star extends Polygon {

        private static final long serialVersionUID = 1L;
        private Point location = null;
        private Color color = Color.YELLOW;
        private int xIncr, yIncr;
        static final int WIDTH = 500, HEIGHT = 500;

        Star(Point location) {
            int x = location.x;
            int y = location.y;
            this.location = location;
            this.addPoint(x, y + 8);
            this.addPoint(x + 8, y + 8);
            this.addPoint(x + 11, y);
            this.addPoint(x + 14, y + 8);
            this.addPoint(x + 22, y + 8);
            this.addPoint(x + 17, y + 12);
            this.addPoint(x + 21, y + 20);
            this.addPoint(x + 11, y + 14);
            this.addPoint(x + 3, y + 20);
            this.addPoint(x + 6, y + 12);
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public void move() {
            if (location.x < 0 || location.x > WIDTH) {
                xIncr = -xIncr;
            }
            if (location.y < 0 || location.y > WIDTH) {
                yIncr = -yIncr;
            }
            translate(xIncr, yIncr);
            location.setLocation(location.x + xIncr, location.y + yIncr);
        }

        public void setxIncr(int xIncr) {
            this.xIncr = xIncr;
        }

        public void setyIncr(int yIncr) {
            this.yIncr = yIncr;
        }

        public Color getColor() {
            return color;
        }
    }

    class MyJPanel extends JPanel {

        private static final long serialVersionUID = 1L;
        private ArrayList<Star> stars = new ArrayList<Star>();
        private Timer timer = new Timer(20, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (Star star : stars) {
                    star.move();
                }
                repaint();
            }
        });

        public void stopAnimation() {
            if (timer.isRunning()) {
                timer.stop();
            }
        }

        public void startAnimation() {
            if (!timer.isRunning()) {
                timer.start();
            }
        }

        @Override
        public void addNotify() {
            super.addNotify();
            timer.start();
        }

        @Override
        public void removeNotify() {
            super.removeNotify();
            timer.stop();
        }

        MyJPanel() {
            this.setPreferredSize(new Dimension(512, 512));
        }

        public void add(Star star) {
            stars.add(star);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            for (Star star : stars) {
                g.setColor(star.getColor());
                g.fillPolygon(star);
            }
        }
    }}