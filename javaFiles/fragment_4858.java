import javax.swing.JFrame;

import java.awt.Graphics;
import java.awt.Color;

public class DrawCirclesInJFrame extends JFrame {
    public static final int INNER_WIDTH = 20;
    public static final int OUTER_WIDTH = 40;

    public DrawCirclesInJFrame() {
        super("Draw Circles In JFrame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);

        g.drawOval(50-INNER_WIDTH/2, 50-INNER_WIDTH/2, INNER_WIDTH, INNER_WIDTH);
        g.drawOval(50-OUTER_WIDTH/2, 50-OUTER_WIDTH/2, OUTER_WIDTH, OUTER_WIDTH);
    }

    public static void main(String[] args) {
        DrawCirclesInJFrame dlijf = new DrawCirclesInJFrame();
    }
}