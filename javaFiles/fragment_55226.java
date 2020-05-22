public interface Paintable {
    public void paint(JComponent parent, Graphics2D g2d);
    public boolean contains(Point p);
    public void moveTo(Point2D p);
    public Rectangle2D getBounds();
}