private GObject getCollidingObject(){
    int x = ball.getX();
    int y = ball.getY();
    if (getElementAt(x, y) != null) {
        return getElementAt(x, y);
    }
    if (getElementAt(x + BALL_RADIUS * 2, y) != null) {
        return getElementAt(x + BALL_RADIUS * 2, y);
    }
    if (getElementAt(x, y + BALL_RADIUS * 2) != null) {
        return getElementAt(x, y + BALL_RADIUS * 2);
    }
    if (getElementAt(x + BALL_RADIUS * 2, y + BALL_RADIUS * 2) != null) {
        return getElementAt(x + BALL_RADIUS * 2, y + BALL_RADIUS * 2);
    }
    return null;
}