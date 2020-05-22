public interface Drawable {
    public Color getStrokeColor();
    public Color getFillColor();
    public Rectangle getBounds();
    public void paint(Graphics2D g2d);
}

public abstract class AbstractDrawable implements Drawable {

    private Color strokeColor;
    private Color fillColor;

    public AbstractDrawable(Color strokeColor, Color fillColor) {
        this.strokeColor = strokeColor;
        this.fillColor = fillColor;
    }

    @Override
    public Color getStrokeColor() {
        return strokeColor;
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

}

public class RectangleDrawable extends AbstractDrawable {

    private Rectangle bounds;

    public RectangleDrawable(int x, int y, int width, int height, Color strokeColor, Color fillColor) {
        super(strokeColor, fillColor);
        bounds = new Rectangle(x, y, width, height);
    }

    @Override
    public Rectangle getBounds() {
        return bounds;
    }

    @Override
    public void paint(Graphics2D g2d) {
        g2d.setColor(getFillColor());
        g2d.fill(getBounds());
        g2d.setColor(getStrokeColor());
        g2d.draw(getBounds());
    }

}

public class OvalDrawable extends AbstractDrawable {

    private Ellipse2D bounds;

    public OvalDrawable(int x, int y, int width, int height, Color strokeColor, Color fillColor) {
        super(strokeColor, fillColor);
        bounds = new Ellipse2D.Double(x, y, width, height);
    }

    @Override
    public Rectangle getBounds() {
        return bounds.getBounds();
    }

    @Override
    public void paint(Graphics2D g2d) {
        g2d.setColor(getFillColor());
        g2d.fill(bounds);
        g2d.setColor(getStrokeColor());
        g2d.draw(bounds);
    }

}