private List<Shape> shapes = new ArrayList<>();

public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.RED);
    for (Shape shape : shapes) {
        g2d.fill(shape);
    }
}