public void move(long elapsedTimeNs) {
    for (Ball ball : balls) {
        ball.move(elapsedTimeNs);
        constrainBall(ball);
        checkForCollisionWithPad(ball);
    }
}