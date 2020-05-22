public void checkCollision() {
      Rectangle playerRect = player.bounds();
      Rectangle ballRect = ball.bounds();
      if (playerRect.intersects(ballRect)) {
          if (ball.getyVelocity() < 0) {
            ball.setxVelocity(5);
            ball.setyVelocity(-5);
        } else if (ball.getyVelocity() > 0) {
            ball.setxVelocity(5);
            ball.setyVelocity(5);
        }
    }
}