import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class GuiButton2 extends JPanel {
    private static final int PREF_W = 400;
    private static final int PREF_H = PREF_W;
    private static final int RECT_X = 40;
    private static final int RECT_Y = 80;
    private static final int RECT_W = 200;
    private static final Color DEFAULT_RECT_COLOR = Color.GRAY;
    private static final Color HOVER_RECT_COLOR = Color.PINK;
    private Rectangle rectangle = new Rectangle(RECT_X, RECT_Y, RECT_W, RECT_W);
    private boolean hover = false;

    public GuiButton2() {
        setPreferredSize(new Dimension(PREF_W, PREF_H));
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                // hover true if mouse is hovering over the rectangle
                hover = rectangle.contains(e.getPoint());
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // if hover true -- use hover color, otherwise use default color
        Color c = hover ? HOVER_RECT_COLOR : DEFAULT_RECT_COLOR;
        g2.setColor(c);
        g2.fill(rectangle);  // draw rectangle
    }

    private static void createAndShowGui() {
        GuiButton2 mainPanel = new GuiButton2();

        JFrame frame = new JFrame("GUI Button");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}