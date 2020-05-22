import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.CellRendererPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PaintComponentTest extends JPanel {

    private static final String s = "<html>all your <font color=\"#ffd700\">base</font> belong to us</html>";
    private JLabel renderer = new JLabel(s);
    private CellRendererPane crp = new CellRendererPane();
    private Dimension dim;

    public PaintComponentTest() {
        this.setBackground(Color.lightGray);
        dim = renderer.getPreferredSize();
        this.add(crp);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        renderer.setForeground(Color.WHITE);
        crp.paintComponent(g, renderer, this, 10, 10, dim.width, dim.height);
    }

    private void display() {
        JFrame f = new JFrame("PaintComponentTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(this);
        f.pack();
        f.setSize(200, 70);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new PaintComponentTest().display();
            }
        });
    }
}