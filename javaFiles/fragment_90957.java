import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** @https://stackoverflow.com/questions/7735774 */
public class ResizeMe extends JPanel {

    private static final int N = 4;
    private static final int SIZE = 100;
    private static final Random rnd = new Random();
    private final List<JLabel> list = new ArrayList<JLabel>();
    private boolean randomize;

    public ResizeMe(boolean randomize) {
        this.randomize = randomize;
        this.setLayout(new GridLayout(1, 0));
        for (int i = 0; i < N; i++) {
            JLabel label = new JLabel();
            label.setPreferredSize(new Dimension(SIZE, SIZE));
            label.setOpaque(true);
            list.add(label);
            this.add(label);
        }
        initColors();
        this.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {
                System.out.println(e);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (randomize) {
            initColors();
        }
    }

    private void initColors() {
        for (JLabel label : list) {
            label.setBackground(new Color(rnd.nextInt()));
        }
    }

    private static void display() {
        JFrame f = new JFrame("ResizeMe");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(0, 1));
        f.add(new ResizeMe(false), BorderLayout.NORTH);
        f.add(new ResizeMe(true), BorderLayout.SOUTH);
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