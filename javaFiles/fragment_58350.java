enum Direction {
    NORTH(0, +1), SOUTH(0, -1), EAST(+1, 0), WEST(-1, 0);

    final int x, y;

    Direction(int x, int y) { this.x = x; this.y = y; }
}

for (Direction dir : Direction.values()) {
    // do something with each direction.
}