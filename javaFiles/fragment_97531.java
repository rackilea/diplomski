import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** #see http://stackoverflow.com/a/10255685/230513 */
public class Test {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrameTest frame = new JFrameTest();
            }
        });
    }
}

class JFrameTest extends JFrame {

    public JFrameTest() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Test");
        this.add(new JPanelTest());
        this.pack();
        this.setLocationByPlatform(true);
        this.setVisible(true);
    }
}

class JPanelTest extends JPanel {

    private static final int R = 60;
    private static final int D = 2 * R;
    private static final int W = 50;
    private static final int E = 2 * W;

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D circle = new Ellipse2D.Double(
            getWidth() - D, getHeight() - D, D, D);
        g2.draw(circle);
        Rectangle2D rect = new Rectangle2D.Double(0, 0, E, E);
        g2.draw(rect);
    }
}