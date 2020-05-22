public class Robot {
    private static final int NORTH = 0, EAST = 1, SOUTH = 2, WEST = 3;
    private int direction;
    private int x, y;

    private Grid grid;

    public Robot(Grid grid) {
        this.x = 0;
        this.y = 0;

        this.grid = grid;
        direction = NORTH;
    }

    public void right() {
        direction++;
        if (direction == 4) {
            direction = 0;
        }
    }

    public void left() {
        direction--;
        if (direction == -1) {
            direction = 3;
        }
    }

    public void forward() {
        if (direction == NORTH) {
            y--;
        } else if (direction == SOUTH) {
            y++;
        } else if (direction == EAST) {
            x++;
        } else if (direction == WEST) {
            x--;
        }
    }

    public void put() {
        grid.put(x, y);
    }

    public void pick() {
        grid.pick(x, y);
    }
}