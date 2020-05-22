import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class RainDropsKeepFalling {

    public static void main(String[] args) {
        new RainDropsKeepFalling();
    }

    public RainDropsKeepFalling() {
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
                frame.add(new RainPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class RainPane extends JPanel {

        private List<Drop> drops = new ArrayList<>(100);

        public RainPane() {
            for (int index = 0; index < 100; index++) {
                drops.add(new Drop(getPreferredSize()));
            }

            Timer timer = new Timer(5, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (Drop drop : drops) {
                        drop.update(getSize());
                        repaint();
                    }
                }
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Drop drop : drops) {
                Graphics2D g2d = (Graphics2D) g.create();
                drop.paint(g2d);
                g2d.dispose();
            }
        }

    }

    protected static final Random random = new Random();

    public static class Drop {

        private double vDelta = random.nextDouble() + 0.5;
        private int height = 15;
        private int width = 3;
        private double x;
        private double y = -height;

        private Rectangle2D shape;

        public Drop(Dimension size) {
            x = random.nextInt(size.width - width) + width;
            y = random.nextInt(size.height - height) + height;
            shape = new Rectangle2D.Double(x, y, width, height);
        }

        public void paint(Graphics2D g2d) {
            g2d.setColor(Color.BLUE);
            g2d.fill(shape);
        }

        public void update(Dimension size) {
            y += vDelta;
            if (y > size.height) {
                y = -height;
                x = random.nextInt(size.width - width) + width;
            }
            shape.setRect(x, y, width, height);
        }

    }

}