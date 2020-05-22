private GObject getCollidingObject(){
    int x = ball.getX();
    int y = ball.getY();
    return getFirstNonNull(getElementAt(x, y),
        getElementAt(x + BALL_RADIUS * 2, y),
        getElementAt(x, y + BALL_RADIUS * 2),
        getElementAt(x + BALL_RADIUS * 2, y + BALL_RADIUS * 2));
}

private static getFirstNonNull(GObject... objects) {
    for (GObject x : objects) {
        if (x != null) {
            return x;
        }
    }
    return null;
}