public static Position getPosition(int dx, int dy) {
    for (Position position : values()) {
        if (position.dx == dx && position.dy == dy) {
            return position;
        }
    }
    return null;
}