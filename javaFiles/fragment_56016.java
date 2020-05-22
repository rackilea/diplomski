public class Circle extends Shape   {

    private int x1, y1, x2, y2;
    private Color updatedColor;
    private ButtonPanel buttonPanel;

    public Circle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void setColor(Color color) {
        updateColor = color;
    }

    public Color getColor() {
        return updateColor;
    }

    @Override
    public void draw(Graphics2D g2) {

        int r = (int)Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getColor()); 
        g2.drawOval(x1 - r, y1 - r, r*2, r*2);
    }

    @Override
    public void update(int x, int y) {
        x2 = x;
        y2 = y;
    }
}