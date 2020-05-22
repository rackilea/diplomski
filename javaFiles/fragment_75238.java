import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class RectButton extends JPanel {

    Rectangle2D.Double rect;

    public RectButton() {
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Point point = e.getPoint();
                System.out.println(checkRectArea(point));
                // Do whatever else you want here.
            }
        });
    }

    public boolean checkRectArea(Point point) {
        return rect.contains(point);
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        rect = new Rectangle2D.Double(10, 10, 50, 50);
        g2.draw(rect);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        RectButton r = new RectButton();
        frame.add(r);
        frame.setSize(new Dimension(300, 300));
        frame.setVisible(true);
    }

}