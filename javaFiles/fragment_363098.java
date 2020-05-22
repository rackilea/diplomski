class BoardSpace {
    private MyColor color;
    private int x_pos;
    private int y_pos;
    private boolean occupied;

    // constructor
    public BoardSpace(MyColor color, int x_pos, int y_pos, boolean occupied) {
        this.color = color;
        this.x_pos = x_pos;
        this.y_pos = y_pos;
        this.occupied = occupied;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public MyColor getColor() {
        return color;
    }

    public int getX_pos() {
        return x_pos;
    }

    public int getY_pos() {
        return y_pos;
    }

}