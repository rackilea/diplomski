import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Test {

    private final JFrame frame = new JFrame();
    private final MyPanel panel = new MyPanel();

    private void createAndShowUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test().createAndShowUI();
            }
        });
    }
}

class MyPanel extends JPanel {

    private List<Rectangle> recs = new ArrayList<>();

    public MyPanel() {
        initComponents();
    }

    private void initComponents() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                addRec(new Rectangle(me.getPoint().x, me.getPoint().y, 100, 50));
                repaint();
            }
        });
    }

    public void addRec(Rectangle rec) {
        recs.add(rec);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        for (Rectangle rec : recs) {
            g2d.drawRect(rec.x, rec.y, rec.width, rec.height);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }
}