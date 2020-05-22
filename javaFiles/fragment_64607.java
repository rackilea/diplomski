enum Direction {
    EAST, WEST, SOUTH, NORTH;

    public Direction dual() {
        Direction direction = null;
        switch (this) {
        case EAST:
            direction = WEST;
            break;
        case WEST:
            direction = EAST;
            break;
        case NORTH:
            direction = SOUTH;
            break;
        case SOUTH:
            direction = NORTH;
            break;
        }
        return direction;
    }
}

public class Main {
    public static void main(String[] args) {
        Direction direction = Direction.NORTH;
        direction = direction.dual().dual();
        System.out.println(direction);
    }
}