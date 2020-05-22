public class DrawingPanel extends JPanel {
    private List<Rectangle> rects = new ArrayList<Rectangle>();

    protected void paintComponent(Grapchics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        for (Rectangle rect: rects) {
            // draw rectangle
        }
    }

    public void addRectangle(Rectangle rect) {
        rects.add(rect);
        repaint();
    }
}