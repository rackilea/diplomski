import java.awt.*;
import java.awt.image.BufferedImage;

public class DropShadowLabel extends AbstractEffectLabel {

    private int shadowSize;
    private Color shadowColor;
    private float shadowAlpha;

    public DropShadowLabel() {

        setShadowSize(2);
        setShadowColor(Color.BLACK);
        setShadowAlpha(0.5f);

    }

    @Override
    protected BufferedImage applyEffectTo(BufferedImage img) {
        return ImageEffectUtilities.applyDropShadow(img, getShadowSize(), getShadowColor(), getShadowAlpha());
    }

    @Override
    public Insets getEffectInsets() {

        return new Insets(0, 0, (getShadowSize() * 2), (getShadowSize() * 2));

    }

    public void setShadowAlpha(float value) {

        if (shadowAlpha != value) {

            float old = shadowAlpha;
            shadowAlpha = value;

            firePropertyChange("shadowAlpha", old, value);
            invalidate();
            repaint();

        }

    }

    public void setShadowColor(Color value) {

        if (shadowColor != value) {

            Color old = shadowColor;
            shadowColor = value;

            firePropertyChange("shadowColor", old, value);
            invalidate();
            repaint();

        }

    }

    public void setShadowSize(int value) {

        if (shadowSize != value) {

            int old = shadowSize;
            shadowSize = value;

            updateRendererSize();

            firePropertyChange("shadowSize", old, value);
            invalidate();
            repaint();

        }

    }

    public float getShadowAlpha() {
        return shadowAlpha;
    }

    public Color getShadowColor() {
        return shadowColor;
    }

    public int getShadowSize() {
        return shadowSize;
    }

}