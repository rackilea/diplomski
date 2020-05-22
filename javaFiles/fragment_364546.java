public class MyCollisionsDispatcher extends CollisionsDispatcher {

    public MyCollisionsDispatcher() {
        // Pre-register all required handlers
        // using Java-8 syntax for "::" instead of anonymous classes
        registerHandler(Ball.class, AbstractBrick.class, this::handleBallBrick);
        registerHandler(AbstractBrick.class, Ball.class, this::handleUsualBrickBall);
        registerHandler(SuperBrick.class, Ball.class, this::handleSuperBrickBall);
    }

    void handleBallBrick(Ball ball, AbstractBrick brick) {
        // bounce of the ball
        // in this case it is not important which brick we hit
        System.out.println("Ball hit some brick");
    }

    void handleUsualBrickBall(AbstractBrick brick, Ball ball) {
        int newCount = brick.getHitCount() - 1;
        if (newCount != 0) {
            brick.setHitCount(newCount);
        } else {
            // remove brick
        }

        System.out.println("Usual brick was hit by a ball. newCount =  " + newCount);
    }

    void handleSuperBrickBall(SuperBrick brick, Ball ball) {
        // do nothing. Super brick is so super!
        System.out.println("Super brick was hit by a ball but nothing happened");
    }
}