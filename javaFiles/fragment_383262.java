import java.awt.*;
import javax.swing.*;

public class Map extends JFrame {
    public static int mapWidth = 576; // The Map's Width
    public static int mapHeight = 598; // The Map's Height
    public static int userX = 1;
    public static int userY = 1;
    private static final long serialVersionUID = 1L;
    public static void main(String[] args) {
        JFrame m1 = new JFrame();
        Container con = m1.getContentPane();
        Color c = new Color(16, 174, 0);
        con.setBackground(c);
        // bad form - pack() instead
        //m1.setSize(mapWidth, mapHeight);
        m1.setTitle("ThomasMosey's Map Generator"); // Window Title
        m1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        User user = new User();
        user.setPreferredSize(new Dimension(300,300));
        con.add(user, BorderLayout.NORTH);
        Grid grid = new Grid();
        grid.setPreferredSize(new Dimension(600,600));
        con.add(grid, BorderLayout.CENTER);
        m1.pack();
        m1.setVisible(true);
    }
}
// The Grid system
class Grid extends JComponent {
    private static final long serialVersionUID = 1L;
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Color gridColor = new Color(0, 84, 12);
        g2.setColor(gridColor);
        int i;
        int i2;
        for(i = 50; i <= Map.mapWidth; i += 51) {
            g2.drawLine(0, i, Map.mapWidth, i);
        }
        for(i2 = 50; i2 <= Map.mapHeight; i2 += 51) {
            g2.drawLine(i2, 0, i2, Map.mapHeight);
        }
    }
}
// Drawing the Grid but lower down to give a significant difference to check whether or not it's actually drawing on the JFrame
class User extends JComponent {
    private static final long serialVersionUID = 1L;
    public void paintComponent(Graphics g2) {
        Graphics2D g22 = (Graphics2D) g2;
        g22.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Color gridColor = new Color(0, 84, 12);
        g22.setColor(gridColor);
        int i22;
        for(i22 = 50; i22 <= 6000; i22 += 53) {
            g22.drawLine(0, i22, Map.mapWidth, i22+1);
        }
    }
}