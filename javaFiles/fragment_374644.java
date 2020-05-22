import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private Point from;
        private Point clickTo;
        private Point to;

        public TestPane() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (to != null) {
                        to = null;
                        clickTo = null;
                        from = null;
                    }
                    if (from != null) {
                        to = e.getPoint();
                        clickTo = new Point(to);
                        double angle = Math.atan2(to.y - from.y, to.x - from.x);
                        int radius = Math.max(getWidth(), getHeight()) * 2;

                        to.x = (int) (Math.round(from.x + (radius * Math.cos(angle))));
                        to.y = (int) (Math.round(from.y + (radius * Math.sin(angle))));
                    } else {
                        from = e.getPoint();
                    }
                    repaint();
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            if (from != null) {
                g2d.setColor(Color.RED);
                g2d.fillOval(from.x - 4, from.y - 4, 8, 8);

                if (to != null) {
                    g2d.setColor(Color.GREEN);
                    g2d.fillOval(clickTo.x - 4, clickTo.y - 4, 8, 8);

                    g2d.setColor(Color.BLUE);
                    g2d.drawLine(from.x, from.y, to.x, to.y);
                }
            }
            g2d.dispose();
        }

    }

}