public class DrawablePane extends JPanel {

    private List<Drawable> drawables;

    public DrawablePane() {
        drawables = new ArrayList<>(25);
    }

    public void add(Drawable drawable) {
        drawables.add(drawable);
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        for (Drawable drawable : drawables) {
            drawable.paint(g2d);
        }
        g2d.dispose();
    }

}