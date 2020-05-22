class Player2 {
    private static final int RECT_WIDTH = 20;
    private static final int RECT_HEIGHT = 50;
    private int x;
    private int y;
    private int ySpeed;
    private Color color;

    public Player2(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setLocation(int x, int y) {
        setX(x);
        setY(y);
    }

    public void move() {
        setLocation(x, y + ySpeed);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, RECT_WIDTH, RECT_HEIGHT);
    }
}