class Ball {
    private int currentX, currentY, width, height;

    public Ball(int x, int y, int w, int h) {
        currentX = x; currentY = y;
        width = w; height = h;
    }

    public void update() {
        currentX++; //moves ball to right
    }

    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(currentX, currentY, width, height);
    }
}