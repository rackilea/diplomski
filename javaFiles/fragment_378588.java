import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {
    private static final Color[] COLORS = { Color.red, Color.orange, Color.yellow, Color.blue,
            Color.green, Color.cyan, Color.magenta };
    private List<Patch> patches = new ArrayList<>();
    Random random = new Random();

    public MainPanel() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // use mousePressed not mouseClicked

                // go backwards for correct handling of overlaps
                for (int i = patches.size() - 1; i >= 0; i--) {
                    if (patches.get(i).contains(e.getPoint())) {
                        System.out.println("pressed");
                        e.consume();
                        return;
                    }
                }
                System.out.println("out");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        MainPanel mainPanel = new MainPanel();
        mainPanel.addPatches();

        frame.add(mainPanel);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void addPatches() {

        for (int i = 0; i < 100; i++) {
            Color c = COLORS[random.nextInt(COLORS.length)];
            patches.add(new Patch(random.nextInt(1000), random.nextInt(800), 30, 30, c));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        patches.forEach(patch -> patch.draw(g));
    }
}

class Patch {

    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private Rectangle rectangle;

    public Patch(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        rectangle = new Rectangle(x, y, width, height);
    }

    public boolean contains(Point p) {
        return rectangle.contains(p);
    }

    public void draw(Graphics g) {
        Color oldColor = g.getColor();
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.setColor(oldColor);
    }

}