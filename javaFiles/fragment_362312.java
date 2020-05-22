public void checkPlayerCollision(Player p1) {
    if (
        // Is the ball at or below paddle height?
        y <= 50
        // AND Is the ball right of the left side of the paddle?
        && x >= p1.getX()
        // AND Is the ball left of the right side of the paddle?
        && x <= p1.getX() + 10
    ) {
        // Collision with the paddle! 
        // (Ball is lower than y=50 and between left and right side of the paddle!)
        // As we want the ball to go back up, we will be changing its velocity
        // along the Y-axis.
        yVel -= yVel;
    } else if (x >= 680) {
        // This checks whether the ball went too far to the right..?
        xVel -= xVel;
    }
}