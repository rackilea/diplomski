import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestGraphNode {

    public static void main(String[] args) {
        new TestGraphNode();
    }

    public TestGraphNode() {
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
                frame.add(new Panneau());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class Panneau extends JPanel {

        private int radius = 50;
        private String text = "stack";

        private List<Ellipse2D> nodes;

        private Ellipse2D dragged;
        private Point offset;

        public Panneau() {
            nodes = new ArrayList<>(25);

            nodes.add(new Ellipse2D.Float(50 - (radius / 2), 100 - (radius / 2), radius, radius));
            nodes.add(new Ellipse2D.Float(350 - (radius / 2), 100 - (radius / 2), radius, radius));

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {

                    for (Ellipse2D node : nodes) {

                        if (node.contains(e.getPoint())) {

                            System.out.println("Clicked...");
                            dragged = node;
                            // Adjust for the different between the top/left corner of the
                            // node and the point it was clicked...
                            offset = new Point(node.getBounds().x - e.getX(), node.getBounds().y - e.getY());
                            // Highlight the clicked node
                            repaint();
                            break;

                        }

                    }

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    // Erase the "click" highlight
                    if (dragged != null) {
                        repaint();
                    }
                    dragged = null;
                    offset = null;
                }
            });

            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    if (dragged != null && offset != null) {
                        // Adjust the position of the drag point to allow for the
                        // click point offset
                        Point to = e.getPoint();
                        to.x += offset.x;
                        to.y += offset.y;

                        // Modify the position of the node...
                        Rectangle bounds = dragged.getBounds();
                        bounds.setLocation(to);
                        dragged.setFrame(bounds);

                        // repaint...
                        repaint();
                    }

                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        @Override
        protected void paintComponent(Graphics g) {
            // declaration
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g.create();
            // Draw the connecting lines first
            // This ensures that the lines are under the nodes...
            Point p = null;
            for (Ellipse2D node : nodes) {

                g2d.setColor(Color.BLACK);
                Point to = node.getBounds().getLocation();
                to.x += radius / 2;
                to.y += radius / 2;
                if (p != null) {
                    g2d.draw(new Line2D.Float(p, to));
                }
                p = to;

            }
            // Draw the nodes...
            for (Ellipse2D node : nodes) {

                g2d.setColor(Color.yellow);
                g2d.fill(node);
                if (node == dragged) {
                    g2d.setColor(Color.BLUE);
                    g2d.draw(node);
                }
                g2d.setColor(Color.BLUE);

                FontMetrics fm = g.getFontMetrics();
                int textWidth = fm.stringWidth(text);
                int x = node.getBounds().x;
                int y = node.getBounds().y;
                int width = node.getBounds().width;
                int height = node.getBounds().height;
                g.drawString(text,
                                x + ((width - textWidth)) / 2,
                                y + ((height - fm.getHeight()) / 2) + fm.getAscent());

            }

            g2d.dispose();

        }

    }
}