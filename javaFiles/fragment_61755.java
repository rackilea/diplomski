class Asteroid2 {
    private static final int[] POLY_X = { 20, 40, 60, 55, 60, 24, 4, 0 };
    private static final int[] POLY_Y = { 0, 7, 20, 40, 80, 70, 40, 0 };
    private static final Color ASTEROID_COLOR = Color.decode("#52575D");
    private Image image;
    private int x;
    private int y;

    public Asteroid2() {
        Polygon poly = new Polygon(POLY_X, POLY_Y, POLY_X.length);
        image = new BufferedImage(60, 80, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(ASTEROID_COLOR);
        g2.fill(poly);
        g2.dispose();
    }

    public void move() {
        x++;
        y++;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void draw(Graphics g) {
        if (image != null) {
            g.drawImage(image, x - 20, y, null);
        }
    }
}