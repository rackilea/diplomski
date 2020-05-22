import java.awt.Color;
import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;

/** @see http://stackoverflow.com/questions/6725618 */
public class AlphaFrame extends Frame {

    private static final Font font = new Font("Dialog", Font.BOLD, 24);
    private float alpha = 1f;
    private Rectangle rect = new Rectangle();

    public static void main(String[] args) {
        AlphaFrame af = new AlphaFrame();
        af.setTitle("Translucent Button");
        af.setAlpha(0.5f);
        af.setForeground(Color.green);
        af.setBackground(Color.black);
        af.setVisible(true);
    }

    public AlphaFrame() {
        this.setSize(320, 240);
        this.setLocationRelativeTo(null);
        this.setBackground(Color.white);
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                if (rect.contains(e.getPoint())) {
                    System.out.println("Pressed.");
                }
            }
        });
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setComposite(AlphaComposite.getInstance(
            AlphaComposite.SRC_OVER, alpha));
        g2.setColor(getForeground());
        g2.setFont(font);
        FontMetrics fm = g2.getFontMetrics();
        String s = getTitle();
        Insets i = getInsets();
        int dx = i.left + 10;
        int dy = i.top + fm.getHeight() + 10;
        Rectangle2D bounds = fm.getStringBounds(s, g);
        rect.x = dx + (int) bounds.getX() - 1;
        rect.y = dy + (int) bounds.getY() - 1;
        rect.width = (int) bounds.getWidth() + 1;
        rect.height = (int) bounds.getHeight() + 1;
        System.out.println(i + " \n" + bounds + "\n" + rect);
        g2.drawRect(rect.x, rect.y, rect.width, rect.height);
        g2.drawString(s, dx, dy);
    }

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }
}