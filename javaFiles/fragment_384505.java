public enum Direction {
    NORTH, SOUTH, WEST, EAST;
    final char  c;

    private Direction() {
        this.c = Character.toLowerCase(this.name().charAt(0));
    }

    public char getChar() {
        return this.c;
    }

    public static Direction byChar(final char c) {
        for (final Direction dir : Direction.values())
            if (dir.c == c) return dir;
        throw new NoSuchElementException("No direction for " + c);
    }
}