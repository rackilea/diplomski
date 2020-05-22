import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;

public class HexPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private List<Hex2b> hex2bs = new ArrayList<>();
    private int radius;
    private int[] rows;

    public HexPanel(int num_columns, int radius, int screen_width, int screen_height) {
        super();
        setBackground(Color.WHITE);
        this.radius = radius;
        hex2bs = new LinkedList<Hex2b>();
        rows = Functions.columns(num_columns);
        int x = screen_width / 6;
        int y = screen_height / 2;
        double height = radius * Math.sqrt(3);
        double range = num_columns - rows[0];
        // build by columns, first
        for (int j = 0; j < num_columns; j++) {
            x += ((3 / 2) * radius) * 1.5015;
            if (j <= Math.floor(num_columns / 2))
                y = (int) (100 - (j * (height / 2)));
            else
                y = (int) ((100 - (height * (range / 2)) + (num_columns - rows[j]) * (height / 2)));
            for (int i = 0; i < rows[j]; i++) {
                y += height;
                Hex2b hex = new Hex2b(i, radius, x, y);
                hex2bs.add(hex);
            }
        }
        addMouseListener(new MyMouse());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // smooth graphics
        // setOpaque(false); // doesn't belong in here
        for (int i = 0; i < hex2bs.size(); i++) {
            Stroke stroke = new BasicStroke(radius / 20, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
            Hex2b hex2b = hex2bs.get(i);
            Color color = hex2b.getColor();
            g2.setColor(color);
            g2.fill(hex2b.getHex());
            g2.setStroke(stroke);
            g2.setColor(Color.BLACK);
            g2.draw(hex2b.getHex());
        }
    }

    private class MyMouse extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            for (Hex2b hex2b : hex2bs) {
                if (hex2b.getHex().contains(e.getPoint())) {
                    hex2b.changeColor();
                    repaint();
                    break;
                }
            }
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Game2b");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Toolkit toolKit = Toolkit.getDefaultToolkit();
        Dimension screen = toolKit.getScreenSize();
        int width = screen.width;
        int height = screen.height;
        frame.getContentPane().add(new HexPanel(11, 100, width, height));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}

class Hex2b {
    private static final Color INIT_COLOR = Color.white;
    private static final Color SELECTED_COLOR = Color.red;
    private int ID;
    private Polygon hexagon;
    private Color color = INIT_COLOR;

    public Hex2b(int ID, int r, int x, int y) {
        super();
        this.ID = ID;
        hexagon = generateHex(r, x, y);
    }

    public Color getColor() {
        return color;
    }

    public void changeColor() {
        color = color == INIT_COLOR ? SELECTED_COLOR : INIT_COLOR;
    }

    public Polygon generateHex(int r, int x, int y) {
        Polygon hexagon = new Polygon();
        for (int i = 0; i < 6; i++) {
            int _x = (int) (x + r * Math.cos(i * 2 * Math.PI / 6));
            int _y = (int) (y + r * Math.sin(i * 2 * Math.PI / 6));
            hexagon.addPoint(_x, _y);
        }
        return hexagon;
    }

    public int getID() {
        return ID;
    }

    public Polygon getHex() {
        return hexagon;
    }
}