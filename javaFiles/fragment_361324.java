import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class HilbertCurve extends JPanel {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                HilbertCurve exemplo1 = new HilbertCurve();
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(exemplo1);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    private SimpleGraphics sg = null;
    private int dist0 = 256;
    private int dist = dist0;

    public HilbertCurve() {
        sg = new SimpleGraphics();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(512, 512);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int level = 4;
        dist = dist0;
        for (int i = level; i > 0; i--) {
            dist /= 2;
        }
        sg.goToXY(dist / 2, dist / 2);
        Graphics2D g2d = (Graphics2D) g.create();
        hilbertU(g2d, level);
        g2d.dispose();

    }

    private void hilbertU(Graphics2D g, int level) {
        if (level > 0) {
            hilbertD(g, level - 1);
            sg.lineRel(g, 0, dist);
            hilbertU(g, level - 1);
            sg.lineRel(g, dist, 0);
            hilbertU(g, level - 1);
            sg.lineRel(g, 0, -dist);
            hilbertC(g, level - 1);
        }
    }

    private void hilbertD(Graphics2D g, int level) {
        if (level > 0) {
            hilbertU(g, level - 1);
            sg.lineRel(g, dist, 0);
            hilbertD(g, level - 1);
            sg.lineRel(g, 0, dist);
            hilbertD(g, level - 1);
            sg.lineRel(g, -dist, 0);
            hilbertA(g, level - 1);
        }
    }

    private void hilbertC(Graphics2D g, int level) {
        if (level > 0) {
            hilbertA(g, level - 1);
            sg.lineRel(g, -dist, 0);
            hilbertC(g, level - 1);
            sg.lineRel(g, 0, -dist);
            hilbertC(g, level - 1);
            sg.lineRel(g, dist, 0);
            hilbertU(g, level - 1);
        }
    }

    private void hilbertA(Graphics2D g, int level) {
        if (level > 0) {
            hilbertC(g, level - 1);
            sg.lineRel(g, 0, -dist);
            hilbertA(g, level - 1);
            sg.lineRel(g, -dist, 0);
            hilbertA(g, level - 1);
            sg.lineRel(g, 0, dist);
            hilbertD(g, level - 1);
        }
    }

    class SimpleGraphics {

//        private Graphics g = null;
        private int x = 0, y = 0;

        public SimpleGraphics() {
        }

        public void goToXY(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void lineRel(Graphics2D g, int deltaX, int deltaY) {
            g.drawLine(x, y, x + deltaX, y + deltaY);
            x += deltaX;
            y += deltaY;
        }
    }
}