import java.awt.*;
import java.awt.geom.AffineTransform;
import javax.swing.*;

/** @see http://stackoverflow.com/questions/6238037 */
public class RotateText extends JPanel {

    private static final Font f = new Font("Serif", Font.BOLD, 32);
    private static final String s = "Hello World!";
    private static final Color[] colors = {
        Color.red, Color.green, Color.blue, Color.cyan
    };
    private Graphics2D g2d;
    private AffineTransform at;

    public RotateText() {
        setPreferredSize(new Dimension(400, 400));
    }

    @Override
    public void paintComponent(Graphics g) {
        g2d = (Graphics2D) g;
        g2d.setFont(f);
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        at = g2d.getTransform();
        int w = this.getWidth();
        int h = this.getHeight();
        int w2 = g2d.getFontMetrics().stringWidth(s) / 2;
        int h2 = 2 * g2d.getFontMetrics().getHeight() / 3;
        render(0, w / 2 - w2, h - h2);
        render(1, h2, h / 2 - w2);
        render(2, w / 2 + w2, h2);
        render(3, w - h2, h / 2 + w2);
        g2d.setTransform(at);
        g2d.setColor(Color.yellow);
        g2d.fillRect(w / 3, h / 3, w / 3, h / 3);
    }

    private void render(int n, int x, int y) {
        g2d.setColor(colors[n]);
        g2d.setTransform(at);
        g2d.rotate(n * Math.PI / 2, x, y);
        g2d.drawString(s, x, y);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            //@Override
            public void run() {
                JFrame f = new JFrame();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.add(new RotateText(), BorderLayout.CENTER);
                f.pack();
                f.setVisible(true);
            }
        });
    }
}