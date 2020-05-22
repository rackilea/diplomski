class MyShape {
    private Path2D path = new Path2D.Double();
    private Color color;

    public MyShape(Shape shape, Color color) {
        path.append(shape, true);
        this.color = color;
    }

    public boolean contains(Point p) {
        return path.contains(p);
    }

    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.draw(path);
    }

    public void fill(Graphics2D g2) {
        g2.setColor(color);
        g2.fill(path);
    }

    public void translate(int deltaX, int deltaY) {
        path.transform(AffineTransform.getTranslateInstance(deltaX, deltaY));
    }

}