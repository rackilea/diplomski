import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;

/** Draws the CannabisCurve
http://mathworld.wolfram.com/CannabisCurve.html
Inspired by a question asked at:
http://math.stackexchange.com/q/618786/38356 */
class CannabisCurve {

    double size = 80d;
    int pad = 5;

    CannabisCurve() {
        JOptionPane.showMessageDialog(null, new ImageIcon(getImage()));
    }

    /** Returns a point for one angle of the Cannabis Curve. */
    public Point2D.Double getPoint(double angle) {
        double r = getR(angle);
        return new Point2D.Double(Math.sin(r), Math.cos(r));
    }

    /** Returns the result of the Cannabis Curve equation for an angle
     * r=(1+0.9cos(8a))(1+0.1cos(24a))(0.9+0.1cos(200a))(1+sin(a))
     * Where 'a' represents the angle. */
    public double getR(double angle) {
        double r = (1 + 0.9 * Math.cos(8 * angle))
                * (1 + (0.1 * Math.cos(24 * angle)))
                * (0.9 + (0.1 * Math.cos(200 * angle))) 
                * (1 + Math.sin(angle));
        return r * size;
    }

    /** Returns a GeneralPath that traces the Cannabis Curve */
    public GeneralPath getCannabisCurve() {
        GeneralPath gp = new GeneralPath();

        boolean first = true;
        for (double a = 0.0; a < 2 * Math.PI; a += .001) {
            double r = getR(a);
            double x = (Math.sin(a) * r);
            double y = (Math.cos(a) * r);
            if (first) {
                gp.moveTo(x, y);
                first = false;
            } else {
                gp.lineTo(x, y);
            }
        }
        gp.closePath();

        // the trace is complete, now we need to transform it.
        AffineTransform rotate = AffineTransform.getRotateInstance(
                3 * Math.PI / 2);
        gp.transform(rotate);

        Rectangle r = gp.getBounds();
        System.out.println(r);
        int imageWidth = r.width + (2 * pad);
        int imageHeight = r.height + (2 * pad);
        int size = (imageWidth > imageHeight ? imageWidth : imageHeight);
        int difference = Math.abs(imageWidth - imageHeight) / 2;

        AffineTransform translate = AffineTransform.getTranslateInstance(
                -(r.x - (pad)), -(r.y - (pad + difference)));
        gp.transform(translate);

        return gp;
    }

    /** Turns the Cannabis Curve into an image */
    public BufferedImage getImage() {
        GeneralPath gp = getCannabisCurve();
        Rectangle r = gp.getBounds();
        int size = r.width+(2*pad);

        BufferedImage bg = new BufferedImage(
                size, size, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,
                RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g.setStroke(new BasicStroke(1.5f));
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, size, size);
        g.setColor(Color.GREEN.darker());
        g.fill(gp);
        g.setColor(Color.GREEN.darker().darker());
        g.draw(gp);
        g.dispose();

        try {
            ImageIO.write(bg, "png", new File("CannabisCurve.png"));
        } catch(Exception e) {
            e.printStackTrace();
        }

        return bg;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                new CannabisCurve();
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
        SwingUtilities.invokeLater(r);
    }
}