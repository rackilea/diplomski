import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class TestScrollPane {

    public static class CustomComponent extends JPanel {

        private static final int RADIUS = 20;
        private int x = 0;
        private int y = 0;

        private double speed = 18;
        private double dx;
        private double dy;

        public CustomComponent() {
            dx = speed;
            dy = speed;
            Timer t = new Timer(20, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    x += dx;
                    y += dy;
                    if (x + RADIUS > getWidth()) {
                        x = getWidth() - RADIUS;
                        dx = -speed;
                    } else if (x < 0) {
                        x = 0;
                        dx = speed;
                    }
                    if (y + RADIUS > getHeight()) {
                        y = getHeight() - RADIUS;
                        dy = -speed;
                    } else if (y < 0) {
                        y = 0;
                        dy = speed;
                    }
                    repaint();
                }
            });
            t.start();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.fillOval(x, y, RADIUS, RADIUS);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(600, 600);
        }
    }

    protected void initUI() {
        JFrame window = new JFrame(TestScrollPane.class.getSimpleName());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane scroll = new JScrollPane(new CustomComponent(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        window.add(scroll);
        window.setSize(600, 500);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestScrollPane().initUI();
            }
        });
    }
}