import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

public class PolygonDetectorPanel extends JPanel implements MouseListener {
    private static final long serialVersionUID = -8929816396666863908L;
    private BufferedImage backgroundImage;
    private List<Polygon> shapes;
    private Polygon selectedPoly;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Polygon Detector");
                PolygonDetectorPanel panel = new PolygonDetectorPanel();

                frame.setContentPane(panel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public PolygonDetectorPanel() {
        super();
        initialize();

        this.addMouseListener(this);
    }

    protected void initialize() {
        try {
            InputStream is = PolygonDetectorPanel.class.getClassLoader().getResourceAsStream("resources/buttons.png");
            this.backgroundImage = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int width = this.backgroundImage.getWidth();
        int height = this.backgroundImage.getHeight();

        this.setPreferredSize(new Dimension(width, height));
        this.shapes = new ArrayList<Polygon>();

        int buttonStartX = 13;
        int buttonStartY = 54;
        int buttonOffset = 100;

        for (int i = 0; i < 4; i++) {
            int[] w  = { buttonStartX       , buttonStartY + 33 + (i * buttonOffset) };
            int[] nw = { buttonStartX +  50 , buttonStartY      + (i * buttonOffset) };
            int[] ne = { buttonStartX + 300 , buttonStartY      + (i * buttonOffset) };
            int[] e  = { buttonStartX + 350 , buttonStartY + 33 + (i * buttonOffset) };
            int[] se = { buttonStartX + 300 , buttonStartY + 66 + (i * buttonOffset) };
            int[] sw = { buttonStartX +  50 , buttonStartY + 66 + (i * buttonOffset) };

            int[] xPoints = { w[0], nw[0], ne[0], e[0], se[0], sw[0], w[0]};
            int[] yPoints = { w[1], nw[1], ne[1], e[1], se[1], sw[1], w[1]};

            this.shapes.add(new Polygon(xPoints, yPoints, 6));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (this.backgroundImage != null) {
            g.drawImage(this.backgroundImage, 0, 0, null);
        }

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10.0f));

        for (Polygon poly : this.shapes) {
            if (poly == this.selectedPoly) {
                g.setColor(Color.GREEN);
            } else {
                g.setColor(Color.RED);
            }

            g.drawPolygon(poly);
        }
    }

    protected Polygon getClickedShape(Point point) {
        for (Polygon poly : this.shapes) {
            if (poly.contains(point)) {
                return poly;
            }
        }

        return null;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Polygon poly = getClickedShape(new Point(e.getX(), e.getY()));

        if (poly != null) {
            this.selectedPoly = poly;
        } else {
            this.selectedPoly = null;
        }

        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }
}