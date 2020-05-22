class Shape {

    int randXLoc;
    int y = D_HEIGHT;
    int randomDelayedStart;
    boolean draw = false;
    boolean down = false;
    Color color;

    public Shape(int randXLoc, int randomDelayedStart, Color color) {
        this.randXLoc = randXLoc;
        this.randomDelayedStart = randomDelayedStart;
        this.color = color;
    }

    public void drawShape(Graphics g) {
        if (draw) {
            g.setColor(color);
            g.fillOval(randXLoc, y, 30, 30);
        }
    }

    public void decreaseDelay() {
        if (randomDelayedStart <= 0) {
            draw = true;
        } else {
            randomDelayedStart -= 1;
        }
    }
}