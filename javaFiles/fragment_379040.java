private boolean playerCollidedWithObstacle() {
    boolean collided = false;

    if (ballAtObstacle()) {
        for (Obstacle obstacle : obstacles) {
            RoundRectangle2D top = obstacle.getTop();
            RoundRectangle2D bottom = obstacle.getBottom();

            if (ball.intersects(top.getX(), top.getY(), top.getWidth(), top.getHeight()) || ball.intersects(bottom.getX(), bottom.getY(), bottom.getWidth(), bottom.getHeight())) {
                collided = true;
            }
        }
    }

    return collided;
}