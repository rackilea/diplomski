import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

class RectangleSubtractedFromLines {

    public static BufferedImage getImage() {
        BufferedImage bi = new BufferedImage(600,200,BufferedImage.TYPE_INT_ARGB);

        Graphics2D g = bi.createGraphics();

        Rectangle2D rect = new Rectangle2D.Double(50,50,100,100);
        // we never draw this, it is used as an area slightly bigger than 
        // the actual rectangle, to subract from the lines to give them space.
        int pad = 8;
        Rectangle2D rectBuffer = new Rectangle2D.Double(
                50-pad,50-pad,100+(2*pad),100+(2*pad));

        // we cannot form an Area from a Line2D, however 
        // we CAN form an Area from a (very thin) Rectangle2D
        Rectangle2D line1 = new Rectangle2D.Double(0,50,600,.02d);
        Rectangle2D line2 = new Rectangle2D.Double(0,149.98,600,.02d);

        Area lines = new Area(line1);
        lines.add(new Area(line2));
        lines.subtract(new Area(rectBuffer));

        g.setColor(Color.RED);
        g.setStroke(new BasicStroke(
                3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g.draw(rect);

        g.setColor(Color.MAGENTA.darker().darker());
        g.setStroke(new BasicStroke(
                6, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g.draw(lines);

        g.dispose();

        return bi;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                JLabel gui = new JLabel(new ImageIcon(
                        RectangleSubtractedFromLines.getImage()));

                JOptionPane.showMessageDialog(null, gui);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
        SwingUtilities.invokeLater(r);
    }
}