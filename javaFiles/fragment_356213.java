public class DrawablePanel extends JPanel {
    private Drawable drawable;


    public DrawablePanel(Drawable drawable) {
        this.drawable = drawable;
    }

    public DrawablePanel() {

    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        if (drawable != null) {
            drawable.draw(g2);
        }
    }
}