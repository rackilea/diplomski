import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JComponent;
import javax.swing.JFrame;

/** @see https://stackoverflow.com/questions/5394364 */
public class LabeledEdge extends JComponent {

    private static final int N = 20;
    private Point n1, n2;

    public LabeledEdge(int w, int h) {
        this.setPreferredSize(new Dimension(w, h));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.n1 = new Point(N, N);
        this.n2 = new Point(getWidth() - N, getHeight() - N);
        g.drawLine(n1.x, n1.y, n2.x, n2.y);
        double d = n1.distance(n2);
        this.setToolTipText(String.valueOf(d));
        g.drawString(String.valueOf((int) d),
            (n1.x + n2.x) / 2, (n1.y + n2.y) / 2);
    }

    private static void display() {
        JFrame f = new JFrame("EdgeLabel");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new LabeledEdge(320, 240));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                display();
            }
        });
    }
}