import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import javax.swing.JLabel;

public abstract class AbstractEffectLabel extends JComponent {

    private JLabel renderer;

    private BufferedImage imgCache;

    public AbstractEffectLabel() {
    }

    protected JLabel getRenderer() {

        if (renderer == null) {

            renderer = new JLabel();
            renderer.setHorizontalTextPosition(JLabel.LEFT);
            renderer.setVerticalTextPosition(JLabel.TOP);

        }

        return renderer;

    }

    @Override
    public void setForeground(Color fg) {
        super.setForeground(fg);
        getRenderer().setForeground(fg);
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        getRenderer().setBackground(bg);
    }

    @Override
    public Font getFont() {
        return getRenderer().getFont();
    }

    public void setHorizontalAlignment(int alignment) {

        getRenderer().setHorizontalAlignment(alignment);

    }

    public void setVerticalAlignment(int alignment) {

        getRenderer().setVerticalAlignment(alignment);

    }

    public void setHorizontalTextPosition(int alignment) {

        getRenderer().setHorizontalTextPosition(alignment);

    }

    public void setVerticalTextPosition(int alignment) {

        getRenderer().setVerticalTextPosition(alignment);

    }

    public int getHorizontalAlignment() {

        return getRenderer().getHorizontalAlignment();

    }

    public int getVerticalAlignment() {

        return getRenderer().getVerticalAlignment();

    }

    public int getHorizontalTextPosition() {

        return getRenderer().getHorizontalTextPosition();

    }

    public int getVerticalTextPosition() {

        return getRenderer().getVerticalTextPosition();

    }

    @Override
    public void setFont(Font font) {

        super.setFont(font);

        getRenderer().setFont(font);

        updateRendererSize();

    }

    @Override
    public void invalidate() {

        imgCache = null;

        super.invalidate();

    }

    public void setText(String text) {

        getRenderer().setText(text);

        updateRendererSize();

        invalidate();
        repaint();

    }

    public String getText() {

        return getRenderer().getText();

    }

    protected abstract BufferedImage applyEffectTo(BufferedImage img);

    protected BufferedImage getImageCache() {

        if (imgCache == null) {

            JLabel renderer = getRenderer();

            imgCache = ImageEffectUtilities.createCompatibleImage(Math.max(1, renderer.getWidth()), Math.max(renderer.getHeight(), 1));
            Graphics2D g2d = imgCache.createGraphics();

            renderer.setForeground(getForeground());

            renderer.paint(g2d);

            g2d.dispose();

//          imgCache = GlowEffectFactory.applyDropShadow(imgCache, getShadowSize(), getShadowColor(), getShadowAlpha());
            imgCache = applyEffectTo(imgCache);

        }

        return imgCache;

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        Rectangle bounds = UIUtilities.getSafeBounds(this);
        g2d.drawImage(getImageCache(), bounds.x, bounds.y, this);

    }

    public abstract Insets getEffectInsets();

    protected void updateRendererSize() {

        Dimension prefSize = getRenderer().getPreferredSize();

        Insets insets = getEffectInsets();

        prefSize.width += (insets.left + insets.right);
        prefSize.height += (insets.top + insets.bottom);

        getRenderer().setSize(prefSize);

        setPreferredSize(prefSize);
        setMinimumSize(prefSize);

    }

}