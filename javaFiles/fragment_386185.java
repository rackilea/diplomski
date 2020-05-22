import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class Site {
    private Integer x;
    private Integer y;
    private Integer width;
    private Integer height;
    // private Graphics2D g2d;
    private boolean isOpen = false;

    private Integer id = null;
    private Integer root = null;

    // !! public Site(Integer id, Integer x, Integer y, Integer width, Integer
    // height, Graphics2D g2d) {
    public Site(Integer id, Integer x, Integer y, Integer width, Integer height) {
        this.id = id;
        this.root = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        // this.g2d = g2d;
    }

    public void draw(Graphics2D g2d) {
        g2d.setPaint(new Color(0, 0, 0));
        g2d.setStroke(new BasicStroke(2));
        Integer x_top_corner = x - (width / 2);
        Integer y_top_corner = y - (height / 2);
        g2d.drawRect(x_top_corner, y_top_corner, width, height);
        System.out.println(x_top_corner);

        if (isOpen) {
            g2d.setPaint(new Color(150, 150, 200));
        } else {
            g2d.setPaint(new Color(200, 200, 200));
        }
        g2d.fillRect(x_top_corner + 1, y_top_corner + 1, width - 2, height - 2);
    }

    public void Open() {
        this.isOpen = true;
    }

    public void Close() {
        this.isOpen = false;
    }
}

class Surface extends JPanel {
    private ArrayList<Site> sites = new ArrayList<Site>();
    private Graphics2D g2d = null;
    private int width;
    private int height;

    public Surface(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(width, height);
    }


    private void initSites() {
        Integer width = 30;
        Integer height = 30;
        Integer index = 0;

        for (Integer y = height; y < 800 - height - 30; y += height) {
            for (Integer x = width; x < 800 - width; x += width) {
                // sites.add(new Site(index, x, y, width, height, g2d));
                sites.add(new Site(index, x, y, width, height)); // !!
                index++;
            }
        }
        Integer x = 20;
        Integer y = 3;
        sites.get(x + (y * 25)).Open();
        sites.get(x + 1 + (y * 25)).Open();
        sites.get(x).Open();
        sites.get(4).Open();
        sites.get(9).Open();
        sites.get(13).Open();
        sites.get(18).Open();
    }

    private void doDrawing(Graphics g) {
        if (sites.size() == 0) {
            initSites();
        }

        for (Site site : sites) {
            site.draw((Graphics2D) g);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}

public class Squares extends JFrame {
    private static final int SIDE_LENGTH = 800;

    public Squares() {
        initUI();
    }

    private void initUI() {
        add(new Surface(SIDE_LENGTH, SIDE_LENGTH));
        setTitle("Squares demo");
        // setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Squares ex = new Squares();
            ex.setVisible(true);
        }); 
    }
}