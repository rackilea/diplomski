import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TreeTest extends JPanel {
    private static final int DISTANCE_X = 4;
    private static final int DISTANCE_Y = 60;

    private int treeArity = 3;
    private int treeDepth = 3;

    public void paintComponent(Graphics g) {
        Dimension size = getSize();
        int x = size.width / 2;
        int y = (size.height + treeDepth * DISTANCE_Y) / 2;

        drawTree(g, x, y, treeArity, treeDepth);
    }

    public static void main(String[] args) throws Exception {
        TreeTest main = new TreeTest();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(main);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}