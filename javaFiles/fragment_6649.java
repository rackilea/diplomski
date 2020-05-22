import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import javax.swing.*;

import javax.imageio.ImageIO;
import java.io.File;

class PaintThick {

    public static void main(String[] args) throws Exception {
        int size = 150;
        final BufferedImage bi = new BufferedImage(
            size,size,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();

        double pad = 20;
        Line2D.Double line1 = new Line2D.Double(
            pad,pad,(double)(size-pad),(double)(size-pad));
        int cap = BasicStroke.CAP_BUTT;
        int join = BasicStroke.JOIN_MITER;
        BasicStroke thick = new BasicStroke(15,cap,join);
        BasicStroke thinner = new BasicStroke(13,cap,join);

        g.setColor(Color.WHITE);
        g.fillRect(0,0,size,size);

        g.setColor(Color.BLACK);
        g.setStroke(thick);
        g.draw(line1);

        g.setColor(Color.WHITE);
        g.setStroke(thinner);
        g.draw(line1);

        ImageIO.write(bi,"png",new File("img.png"));
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(
                    null, new JLabel(new ImageIcon(bi)));
            }
        });
    }
}