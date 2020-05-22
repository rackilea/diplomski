import java.awt.*;

public class TestComponent extends JPanel {

    private void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawString(g, "hello\nworld", 20, 20);
        g.setFont(g.getFont().deriveFont(20f));
        drawString(g, "part1\npart2", 120, 120);
    }

    public static void main(String s[]) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new TestComponent());
        f.setSize(220, 220);
        f.setVisible(true);
    }
}