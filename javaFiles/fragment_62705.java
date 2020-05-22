import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.LayoutManager2;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AbsoluteLayoutExample {

    public static void main(String[] args) {
        new AbsoluteLayoutExample();
    }

    public AbsoluteLayoutExample() {
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

        public TestPane() {

            setLayout(new AbsoluateLayoutManager());

            JLabel test = new JLabel("Test");
            add(test);

            MouseAdapter ma = new MouseAdapter() {

                private Point offset;
                private Component dragComp;

                @Override
                public void mousePressed(MouseEvent e) {
                    Point point = e.getPoint();
                    for (Component comp : getComponents()) {
                        if (comp.getBounds().contains(point)) {
                            offset = new Point(point.x - comp.getX(), point.y - comp.getY());
                            dragComp = comp;
                        }
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    offset = null;
                    dragComp = null;
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    if (dragComp != null) {
                        Point p = e.getPoint();
                        Point dragP = new Point(p.x - offset.x, p.y - offset.y);
                        dragComp.setLocation(dragP);
                    }
                }

            };

            addMouseListener(ma);
            addMouseMotionListener(ma);

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

    public class AbsoluateLayoutManager implements LayoutManager2 {

        @Override
        public void addLayoutComponent(Component comp, Object constraints) {
        }

        @Override
        public Dimension maximumLayoutSize(Container target) {
            return preferredLayoutSize(target);
        }

        @Override
        public float getLayoutAlignmentX(Container target) {
            return 0.5f;
        }

        @Override
        public float getLayoutAlignmentY(Container target) {
            return 0.5f;
        }

        @Override
        public void invalidateLayout(Container target) {
        }

        @Override
        public void addLayoutComponent(String name, Component comp) {
        }

        @Override
        public void removeLayoutComponent(Component comp) {
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            int maxX = 0;
            int maxY = 0;
            for (Component comp : parent.getComponents()) {
                Dimension size = comp.getPreferredSize();
                maxX = Math.max(comp.getX() + size.width, maxX);
                maxY = Math.max(comp.getY() + size.height, maxY);
            }

            return new Dimension(maxX, maxY);
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            return preferredLayoutSize(parent);
        }

        @Override
        public void layoutContainer(Container parent) {
            for (Component comp : parent.getComponents()) {
                Dimension size = comp.getPreferredSize();
                comp.setSize(size);
            }
        }

    }

}