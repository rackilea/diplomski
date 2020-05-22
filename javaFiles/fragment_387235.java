import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;

public class IconTest {

    public static void main(String[] args) {
        Path2D path = new Path2D.Double();
        path.moveTo(0, 0);
        path.lineTo(15, 0);
        path.lineTo(8, 15);
        path.lineTo(0, 0);
        JToolBar toolbar = new JToolBar();
        // use Icon wrapper around the shape
        JButton btn = new JButton(new ShapeIcon(path, Color.CYAN));
        btn.setFocusable(false);
        toolbar.add(btn);
        // use conversion of shape into the icon
        btn = new JButton(toIcon(path, Color.GREEN));
        btn.setFocusable(false);
        toolbar.add(btn);
        JFrame frm = new JFrame("Test");
        frm.add(toolbar, BorderLayout.NORTH);
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frm.setSize(400, 300);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }

    private static Icon toIcon(Shape shape, Color color) {
        BufferedImage img = new BufferedImage(shape.getBounds().width, shape.getBounds().height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setColor(color);
        g2.fill(shape);
        // g2.draw(shape);
        g2.dispose();
        return new ImageIcon(img);
    }

    private static class ShapeIcon implements Icon {

        private final Shape shape;

        private final Color color;

        /**
         * @param shape
         */
        public ShapeIcon(Shape shape, Color color) {
            this.shape = shape;
            this.color = color;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(color);
            AffineTransform transform = new AffineTransform();
            transform.translate(x, y);
            g2.fill(transform.createTransformedShape(shape));
            // g2.draw(transform.createTransformedShape(shape));
        }

        @Override
        public int getIconWidth() {
            return shape.getBounds().width;
        }

        @Override
        public int getIconHeight() {
            return shape.getBounds().height;
        }

    }
}