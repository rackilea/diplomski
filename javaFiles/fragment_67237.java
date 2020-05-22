import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

public class DrawRect extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        int w = getWidth();
        int h = getHeight();
        g.drawRect(w/10, h/10, w/2, h/2);
    }

    /* A custom component should give the layout manager hints as to
    its preferred size. */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200,200);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        DrawRect panel = new DrawRect();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}