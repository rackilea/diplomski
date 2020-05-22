public class PaintingPanel extends JPanel {
    private List<Drawable> objects;
    BreakOut breakOut;

    public PaintingPanel(BreakOut breakout) {
        this.breakOut = breakOut;
        this.objects = breakOut.getSomething();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Drawable object: objects) {
            object.draw(g);
        }
    }
}