import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PaintedButton extends JPanel {
    private static final Color HOVER_COLOR = Color.BLUE;
    private static final Color NON_HOVER_COLOR = Color.GREEN;
    private static final Rectangle2D RECTANGLE = new Rectangle2D.Double(50, 50,
            200, 100);

    private Color color = NON_HOVER_COLOR;

    public PaintedButton() {
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                Point p = e.getPoint();
                if (RECTANGLE.contains(p)) {
                    color = HOVER_COLOR;
                } else {
                    color = NON_HOVER_COLOR;
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(color);
        g2.fill(RECTANGLE);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 200);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new PaintedButton());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}