import java.text.NumberFormat;
import java.util.Objects;

import java.awt.EventQueue;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.FontMetrics;

import java.awt.Dimension;
import java.awt.Shape;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextLayout;

import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class ShapeFiller
extends JPanel {
    private static final long serialVersionUID = 1;

    private final Shape shape;

    private final Timer fillTimer;

    private float percentageFilled;

    private final NumberFormat percentageFormat;

    private final Rectangle textBounds = new Rectangle();
    private final Rectangle iconBounds = new Rectangle();

    public ShapeFiller(Shape shape) {
        this(shape, 250);
    }

    public ShapeFiller(Shape shape,
                       int fillDelayMillis) {
        this.shape = Objects.requireNonNull(shape, "Shape cannot be null");
        this.percentageFormat = NumberFormat.getPercentInstance();
        this.fillTimer = new Timer(Math.max(50, fillDelayMillis),
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    incrementPercentage();
                }
            });

        setFont(getFont().deriveFont(getFont().getSize2D() * 4));
    }

    @Override
    public Dimension getPreferredSize() {
        Rectangle bounds = shape.getBounds();
        bounds.add(0, 0);
        return bounds.getSize();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D g = (Graphics2D) graphics;
        g.draw(shape);

        // Fill shape 

        Shape originalClip = g.getClip();

        Rectangle bounds = shape.getBounds();
        int clipHeight = (int) (bounds.height * percentageFilled);
        g.clip(new Rectangle(0, bounds.y + bounds.height - clipHeight,
            getWidth(), clipHeight));
        g.fill(shape);

        g.setClip(originalClip);

        // Draw percentage

        String text = percentageFormat.format(percentageFilled);
        TextLayout layout =
            new TextLayout(text, g.getFont(), g.getFontRenderContext());

        FontMetrics metrics = g.getFontMetrics();
        iconBounds.setBounds(0, 0, 0, 0);
        textBounds.setBounds(0, 0, 0, 0);
        SwingUtilities.layoutCompoundLabel(this,
            metrics, text, null,
            SwingConstants.CENTER, SwingConstants.CENTER,
            SwingConstants.CENTER, SwingConstants.CENTER,
            bounds, iconBounds, textBounds, 0);
        int textX = textBounds.x;
        int textY = textBounds.y + metrics.getAscent();

        Paint originalPaint = g.getPaint();
        g.setPaint(getBackground());
        layout.draw(g, textX, textY);
        g.setPaint(originalPaint);

        // Draw percentage outline

        AffineTransform textPos =
            AffineTransform.getTranslateInstance(textX, textY);
        g.draw(layout.getOutline(textPos));
    }

    public void setPercentageDone(float percentage) {
        if (Float.isNaN(percentage) || Float.isInfinite(percentage)) {
            throw new IllegalArgumentException("Percentage must be finite");
        }
        percentageFilled = Math.max(0, Math.min(1, percentage));
        repaint();
    }

    public void startFilling() {
        percentageFilled = 0;
        fillTimer.restart();
    }

    private void incrementPercentage() {
        setPercentageDone(percentageFilled + 0.01f);
        if (percentageFilled >= 1) {
            fillTimer.stop();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Shape shape = new Ellipse2D.Float(50, 50, 200, 200);
                ShapeFiller shapeFiller = new ShapeFiller(shape);
                shapeFiller.startFilling();
                JOptionPane.showMessageDialog(null, shapeFiller);
                System.exit(0);
            }
        });
    }
}