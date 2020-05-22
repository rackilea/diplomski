class PolygonShape {

    int x, y, r;
    private Polygon p;

    public PolygonShape(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;       
    }

    // Provide a default radius of 100 pixels if no radius is given.
    public PolygonShape(int x, int y) {
        this(x, y, 100);
    }

    public void draw(Graphics g) {       
        p = new Polygon();
        for (int i = 0; i < 5; i++) {
            double angle = i * 2 * Math.PI / 5;
            p.addPoint((int) (x + r * Math.cos(angle)),
                       (int) (y + r * Math.sin(angle)));
        }
        g.drawPolygon(p); 
    }
}