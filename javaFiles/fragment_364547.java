public void test() {
    AbstractObject simpleBrick = new SimpleBrick();
    AbstractObject doubleBrick = new DoubleBrick();
    AbstractObject superBrick = new SuperBrick();
    AbstractObject ball = new Ball();

    CollisionsDispatcher dispatcher = new MyCollisionsDispatcher();

    dispatcher.handleCollision(ball, simpleBrick);
    dispatcher.handleCollision(simpleBrick, ball);

    dispatcher.handleCollision(ball, doubleBrick);
    dispatcher.handleCollision(doubleBrick, ball);
    dispatcher.handleCollision(doubleBrick, ball);

    dispatcher.handleCollision(ball, superBrick);
    dispatcher.handleCollision(superBrick, ball);
    dispatcher.handleCollision(superBrick, ball);
}