import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;

import javax.swing.Icon;

public class ColorIconRound implements Icon {

private int size;
private Paint color;

public ColorIconRound(int size, Paint color) {
    this.size = size;
    this.color = color;
}

@Override
public void paintIcon(Component c, Graphics g, int x, int y) {
    Graphics2D g2d = (Graphics2D) g;
    Paint op = g2d.getPaint();
    g2d.setRenderingHint(
        RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setPaint(color);
    g2d.fillOval(x, y, size, size);
    g2d.setPaint(op);
}

@Override
public int getIconWidth() {
    return size;
}

@Override
public int getIconHeight() {
    return size;
}

}