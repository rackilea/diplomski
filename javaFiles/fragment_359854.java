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
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FlyingBoxes {

    public static void main(String[] args) {
        new FlyingBoxes();
    }

    public interface Drawable {

        public void update(JComponent comp);

        public void draw(Graphics g);

    }

    public class Box implements Drawable {

        private int x;
        private int y;
        private int width = 10;
        private int height = 10;

        private int xDelta;
        private int yDelta;

        public Box(int x, int y) {
            this.x = x;
            this.y = y;

            xDelta = random();
            yDelta = random();
        }

        @Override
        public void update(JComponent comp) {
            x += xDelta;
            y += yDelta;
            if (x < 0) {
                x = 0;
                xDelta *= -1;
            } else if (x + width > comp.getWidth()) {
                x = comp.getWidth() - width;
                xDelta *= -1;
            }
            if (y < 0) {
                y = 0;
                yDelta *= -1;
            } else if (y + height > comp.getHeight()) {
                y = comp.getHeight() - height;
                yDelta *= -1;
            }
        }

        @Override
        public void draw(Graphics g) {
            g.setColor(Color.BLUE);
            g.fillRect(x, y, width, height);
        }

        protected int random() {

            int value = 0;
            do {
                value = -2 + (int)(Math.random() * 4);
            } while (value == 0);

            return value;

        }

    }

    public FlyingBoxes() {
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
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private List<Drawable> drawables;

        public TestPane() {
            drawables = new ArrayList<>(25);
            for (int index = 0; index < 25; index++) {
                int x = (int) (Math.random() * 190);
                int y = (int) (Math.random() * 190);
                drawables.add(new Box(x, y));
            }

            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (Drawable d : drawables) {
                        d.update(TestPane.this);
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
            for (Drawable d : drawables) {
                d.draw(g);
            }
        }
    }

}