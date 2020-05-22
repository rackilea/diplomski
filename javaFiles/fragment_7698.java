import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
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
                frame.add(new TestPane());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.addComponentListener(new ComponentAdapter() {
                    private boolean ignoreNext = false;
                    @Override
                    public void componentResized(ComponentEvent e) {
                        if (ignoreNext) {
                            ignoreNext = false;
                            return;
                        }
                        Insets insets = frame.getInsets();
                        ignoreNext = true;
                        int width = Math.max(frame.getWidth(), frame.getContentPane().getMinimumSize().width + (insets.left + insets.right));
                        int height = Math.max(frame.getHeight(), frame.getContentPane().getMinimumSize().height + (insets.top + insets.bottom));
                        frame.setSize(width, height);
                    }
                });
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private Rectangle rect;

        public TestPane() {
            MouseAdapter ma = new MouseAdapter() {
                private Point anchor;

                @Override
                public void mouseDragged(MouseEvent e) {
                    Point p = e.getPoint();
                    int minX = Math.min(anchor.x, p.x);
                    int minY = Math.min(anchor.y, p.y);
                    int maxX = Math.max(anchor.x, p.x);
                    int maxY = Math.max(anchor.y, p.y);

                    rect = new Rectangle(minX, minY, maxX - minX, maxY - minY);
                    repaint();
                    revalidate();
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    anchor = e.getPoint();
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    anchor = null;
                }
            };
            addMouseMotionListener(ma);
            addMouseListener(ma);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(600, 600);
        }

        @Override
        public Dimension getMinimumSize() {
            if (rect == null) {
                return super.getMinimumSize();
            }
            Dimension size = new Dimension(rect.x + rect.width, rect.y + rect.height);
            return size;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (rect == null) {
                return;
            }
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.BLUE);
            g2d.fill(rect);
            g2d.dispose();
        }

    }

}