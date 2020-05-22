private void update() {
    if (ballOutOfBounds() || playerCollidedWithObstacle()) {
        endGame();
    } else if (ballPassedObstacle()) {
        addToScore();
        setupNextObstacle();
    }


    updateBallPosition();
    updateObstaclePositions();
}